package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator
{

    public Predicate<List<String>> isValuesStartWithUpperCase()
    {
        return strings ->
        {
            for (String string : strings)
            {
                char firstCharOfString = string.charAt(0);
                if (!Character.isUpperCase(firstCharOfString))
                {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd()
    {
        return list ->
        {
            List<Integer> tempList = new ArrayList<>(list);
            for (Integer element : tempList)
            {
                if (element % 2 == 0)
                {
                    list.add(element);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values)
    {
        return () ->
        {
            List<String> result = new ArrayList<>();
            if (values.size() > 0)
            {

            }
            for (String string : values)
            {
                String[] words = string.split(" ");
                if (words.length > 3)
                {
                    String firstWord = words[0];
                    char firstLetterOfFirstWord = firstWord.charAt(0);
                    String lastWord = words[words.length - 1];
                    int indexOfCharactersOfLastWord = lastWord.length() - 1;
                    char lastLetterOfLastWord = lastWord.charAt(indexOfCharactersOfLastWord);
                    if (Character.isUpperCase(firstLetterOfFirstWord) && lastLetterOfLastWord == '.')
                    {
                        result.add(string);
                    }
                }
            }
            return result;
        };
    }

    /*String must start with the letter in upper case;
    String must end with '.';
    String must contain more than 3 words;*/

    public Function<List<String>, Map<String, Integer>> stringSize()
    {
        return list -> {
            Map<String, Integer> resultMap = new HashMap<>();
            for (String string : list){
                resultMap.put(string, string.length());
            }
            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList()
    {
        return (list1, list2) -> {
            List<Integer> resultList = new ArrayList<>(list1);
            resultList.addAll(list2);
            return resultList;
        };
    }
}
