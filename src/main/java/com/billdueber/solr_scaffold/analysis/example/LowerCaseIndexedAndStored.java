package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.schema.MungedStringIndexedAndStored;

public class LowerCaseIndexedAndStored extends MungedStringIndexedAndStored {

  @Override
  public String munge(String str) {
    return str.toLowerCase();
  }

}
