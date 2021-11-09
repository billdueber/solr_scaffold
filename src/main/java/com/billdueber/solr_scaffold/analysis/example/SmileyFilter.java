package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.analysis.SimpleFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * A subclass of SimpleFilter needs to have this two-argument
 * constructor that does nothing but call `super` and an implementation
 * of `munge` to take the input string and turn it into whatever you
 * actually want indexed.
 */

public class SmileyFilter extends SimpleFilter {

  public SmileyFilter(TokenStream aStream, Boolean echoInvalidInput) {
    super(aStream, echoInvalidInput);
  }

  @Override
  public String munge(String str) {
    return str.replaceAll("[Oo]", "😀");
  }

}
