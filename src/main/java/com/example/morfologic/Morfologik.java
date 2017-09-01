package com.example.morfologic;


import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Morfologik {

    private static final String template = "Hello, %s!";

    @PostMapping(value = "/morfologik/{word}")
    @ResponseBody
    public String greeting(@PathVariable("word") String word) {

        PolishStemmer ps = new PolishStemmer();
        List<WordData> lookup = ps.lookup(word);

        return lookup.toString();
    }

    @PostMapping(value = "/morfologik/{word}/{morfo}")
    @ResponseBody
    public String greeting(@PathVariable("word") String word, @PathVariable("morfo") String morfo) {

        PolishStemmer ps = new PolishStemmer();
        List<WordData> lookup = ps.lookup(word + "|" + morfo);

        return lookup.toString();
    }
}