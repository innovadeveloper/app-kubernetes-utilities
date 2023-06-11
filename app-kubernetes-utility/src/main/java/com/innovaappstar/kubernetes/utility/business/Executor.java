package com.innovaappstar.kubernetes.utility.business;

import com.github.javaparser.utils.Pair;

import java.util.List;
import java.util.function.BiPredicate;

public interface Executor {
    public List<String[]> process();
    public String[] getPathItemList();
    public BiPredicate<Pair<String, String>, String[]> onFilterByColumnAndValue();

}
