package com.example.stoks.response;

import com.example.stoks.dto.CategoryDto;
import com.example.stoks.model.BaseEntity;

import java.io.Serializable;

public class CategoryResponse extends BaseResponse implements Serializable {

    public CategoryDto category;
}
