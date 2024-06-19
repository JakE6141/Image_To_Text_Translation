package com.shipzz.gamez;

import java.io.File;
import java.util.*;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class Main {
    public static void main(String[] args)throws Exception {

        String translatedData;
        Scanner scanner = new Scanner(System.in);

        System.out.println("English to spanish picture translator");
        System.out.println("Acceptable languages: Spanish, Hungarian, Italian, Japanese, Korean \n"+
                            "Russian, German, Arabic, French and Mandarin Chinese(enter mandarin)");
        System.out.print("Enter language: ");
        String lang = scanner.nextLine();
        System.out.print("Enter Path to picture(no double quotes): \n");
        String path = scanner.nextLine();

        String finalLang = key(lang);



        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath(Config.TESSDATA_PATH);



            String text = tesseract.doOCR(new File(path));

            translatedData = LangCall.getTranslation(text,finalLang);


            System.out.println("Image to word(s): "+text+"\n");
            System.out.println("Translated word(s): "+translatedData);

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    public static String key(String lang){
        switch (lang.toLowerCase()) {
            case "spanish":
                return "es";
            case "hungarian":
                return "hu";
            case "italian":
                return "it";
            case "japanese":
                return "ja";
            case "korean":
                return "ko";
            case "russian":
                return "ru";
            case "german":
                return "de";
            case "arabic":
                return "ar";
            case "french":
                return "fr";
            case "mandarin":
                return "zh";
            default:
                return null;
        }
    }
}