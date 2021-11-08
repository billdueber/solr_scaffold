package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.analysis.MungeSingleTokenFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * A subclass of MungeSingleTokenFilter needs to have this two-argument
 * constructor that does nothing but call `super` and an implementation
 * of `munge` to take the input string and turn it into whatever you
 * actually want indexed.
 */

public class LowerCaserFilter extends MungeSingleTokenFilter {

  public LowerCaserFilter(TokenStream aStream, Boolean echoInvalidInput) {
    super(aStream, echoInvalidInput);
  }

  @Override
  public String munge(String str) {
    return str.toLowerCase();
  }

}
