package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.utils.Pair;
import com.innovaappstar.kubernetes.utility.constants.NodePropertyEnum;
import com.innovaappstar.kubernetes.utility.utils.JsonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public abstract class BaseExecutor {

    public List<String[]> toConvertToListString(JsonNode jsonNode){
        List<List<String>> itemList = Arrays.stream(getPathItemList()).map((pathItem) -> JsonUtils.getNodeValues(jsonNode, pathItem)).collect(Collectors.toList());
        return JsonUtils.mergeLists(itemList);
    }

    public String[] getPathItemList(){
        return new String[]{
            NodePropertyEnum.KIND.getValue(),
            NodePropertyEnum.METADATA_NAME.getValue(),
            NodePropertyEnum.METADATA_NAMESPACE.getValue(),
            NodePropertyEnum.METADATA_UID.getValue(),
            NodePropertyEnum.METADATA_CREATION_TIMESTAMP.getValue()
        };
    }

    public BiPredicate<Pair<String, String>, String[]> onFilterByColumnAndValue() {
        return (inputPair, rowData) -> {
            String inputFilter = inputPair.a;
            String cbFilter = inputPair.b;
            int columnIndex = JsonUtils.indexOf(getPathItemList(), cbFilter);
            if (columnIndex < 0)
                throw new ArrayIndexOutOfBoundsException("valor no encontrado en el arreglo");
            String valueFromFilteredColumn = rowData[columnIndex];
            return valueFromFilteredColumn.toLowerCase().contains(inputFilter.toLowerCase());
        };
    }

}
