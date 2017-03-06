package com.geekhub.userapp.web.pagination;

import com.geekhub.userapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class PaginationUtils {

    private PaginationUtils() {
    }

    public static <T> Page<T> getPage(List<T> items, PageRequest pageRequest) {
        ArrayList<T> list = new ArrayList();
        int count = items.size() / pageRequest.getPerPage() + 1;
        int pageNumb = pageRequest.getPage() - 1;
        int pageCount = pageRequest.getPerPage();
        int position = pageCount * pageNumb;
        list.addAll(items.subList(position, position + pageCount > items.size() ? items.size() : position + pageCount));
        return new <T>Page<T>(pageRequest.getPage(), count, list);
    }


}
