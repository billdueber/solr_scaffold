package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.schema.MungedStringIndexedOnly;

public class LowerCaseIndexedOnly extends MungedStringIndexedOnly {

  @Override
  public String munge(String str) {
    return str.toLowerCase();
  }

}
