package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.schema.StringMungedIndexMungedStored;

public class SmileyIndexedAndStored extends StringMungedIndexMungedStored {

  @Override
  public String munge(String str) {
    return str.replaceAll("[Oo]", "😀");
  }
}
