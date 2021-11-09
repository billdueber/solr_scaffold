package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.schema.MungedStringIndexedAndStored;

public class SmileyIndexedAndStored extends MungedStringIndexedAndStored {

  @Override
  public String munge(String str) {
    return str.replaceAll("[Oo]", "😀");
  }
}
