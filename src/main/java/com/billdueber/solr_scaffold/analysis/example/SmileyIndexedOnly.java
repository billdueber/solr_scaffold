package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.schema.StringMungedIndexPlainStored;

public class SmileyIndexedOnly extends StringMungedIndexPlainStored {

  @Override
  public String munge(String str) {
    return str.replaceAll("[Oo]", "😀");
  }

}
