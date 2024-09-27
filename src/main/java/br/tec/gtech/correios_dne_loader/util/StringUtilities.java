package br.tec.gtech.correios_dne_loader.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public final class StringUtilities {

    private static final String EMPTY_STRING = "";
    private static final Pattern ACENTOS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    
    private StringUtilities(){

    }

    public static String removerAcentos(String texto) {
        return ACENTOS.matcher(Normalizer.normalize(texto, Normalizer.Form.NFD)).replaceAll(EMPTY_STRING);
    }
}