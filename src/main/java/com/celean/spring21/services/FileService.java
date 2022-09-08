package com.celean.spring21.services;

import com.celean.spring21.models.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service

public class FileService {
    private static int rowNum = 0;
    private final String baseDir;
    private String productFileName;

    public String getProductFileName(){
        return this.productFileName;
    }

    public FileService(@Value("${geek.storage.path}") String baseDir) throws IOException {
        this.baseDir = baseDir;
        Path dir = Path.of(baseDir);
        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }
    }

    public void saveProductFile(String fileName, List<Product> productList){
        productFileName = String.valueOf(Path.of(baseDir).resolve(fileName).toFile());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Products");

        for (Product p : productList){
            Row row = sheet.createRow(rowNum++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(p.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(p.getTitle());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(p.getPrice());
        }

        try {
            FileOutputStream out = new FileOutputStream(productFileName);
            workbook.write(out);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Path getFilePath(String fileName) {
        return Path.of(baseDir).resolve(fileName);
    }

    public byte[] getFileData() throws IOException {
        return Files.readAllBytes(getFilePath(productFileName));
    }
}
