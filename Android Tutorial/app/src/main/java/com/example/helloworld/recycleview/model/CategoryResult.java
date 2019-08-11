package com.example.helloworld.recycleview.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("listCate")
@Expose
public List<Category> listCate = null;
