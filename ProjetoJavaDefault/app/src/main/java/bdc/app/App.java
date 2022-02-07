/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bdc.app;

import bdc.list.LinkedList;

import static bdc.utilities.StringUtils.join;
import static bdc.utilities.StringUtils.split;
import static bdc.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}