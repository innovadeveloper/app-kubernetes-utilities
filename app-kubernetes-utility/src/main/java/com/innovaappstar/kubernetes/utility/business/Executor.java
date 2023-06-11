package com.innovaappstar.kubernetes.utility.business;

import java.util.List;

public interface Executor {
    public List<String[]> process();
    public String[] getPathItemList();
}
