package de.vorb.libtesseract.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.jna.Native;
import com.sun.jna.ptr.PointerByReference;

import de.vorb.libtesseract.LibTesseract;

public class BasicExample {
  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    
    final String libraryName = "libTesseract303";

    // load the library
    final LibTesseract lib = (LibTesseract) Native.loadLibrary(
        libraryName, LibTesseract.class);

    // create a reference to an execution handle
    final PointerByReference handle = lib.TessBaseAPICreate();

    // init Tesseract with data path, language and OCR engine mode
    lib.TessBaseAPIInit2(handle, "E:\\Masterarbeit\\Ressourcen\\tessdata",
        "deu-frak", LibTesseract.TessOcrEngineMode.OEM_DEFAULT);

    // set page segmentation mode
    lib.TessBaseAPISetPageSegMode(handle, LibTesseract.TessPageSegMode.PSM_AUTO);

    // read the image into memory
    final BufferedImage inputImage = ImageIO.read(new File("input.png"));

    // get the image data
    final byte[] imageData = ((DataBufferByte) inputImage.getRaster().getDataBuffer()).getData();

    // image properties
    final int width = inputImage.getWidth(), height = inputImage.getHeight();
    final int bitsPerPixel = inputImage.getColorModel().getPixelSize();
    final int bytesPerPixel = bitsPerPixel / 8;
    final int bytesPerLine = (int) Math.ceil(width * bitsPerPixel / 8.0);

    // set the image
    lib.TessBaseAPISetImage(handle, imageData, width, height, bytesPerPixel,
        bytesPerLine);

    // get the hOCR result
    final String hocr = lib.TessBaseAPIGetUTF8Text(handle);

    // print the result
    System.out.println(hocr);

    // calculate the time
    System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");

    // delete handle
    lib.TessBaseAPIDelete(handle);
  }
}