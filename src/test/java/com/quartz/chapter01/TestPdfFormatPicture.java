/*
package com.ittzg.pdfformatpicture;

import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.util.GraphicsRenderingHints;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;

import static sun.plugin.javascript.navig.JSType.Document;

*/
/**
 * @Author: ittzg
 * @CreateDate: 2018/12/10 15:31
 * @Description: 将pdf转为图片
 *//*

public class TestPdfFormatPicture {
    public static void pdfToPic(String pdfPath, String path){
        try {
            Document document = new Document();
            document.setFile(pdfPath);
            float scale = 2.5f;//缩放比例
            float rotation = 0f;//旋转角度

            for (int i = 0; i < document.getNumberOfPages(); i++) {
                BufferedImage image = (BufferedImage)
                        document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
                RenderedImage rendImage = image;
                try {
                    String imgName = i + ".png";
                    System.out.println(imgName);
                    File file = new File(path + imgName);
                    ImageIO.write(rendImage, "png", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                image.flush();
            }
            document.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filePath = "H:\\深入理解JAVA内存模型.pdf";
        pdfToPic(filePath, "H:\\JVM\\");
    }
}
*/
