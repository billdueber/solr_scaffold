package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.analysis.MungeSingleTokenFilterFactory;
import org.apache.lucene.analysis.TokenStream;

import java.util.Map;

/**
 * You should be able to just search-and-replace LowerCaserFilter with whatever your
 * filter is called and leave everything else alone.
 */
public class LowerCaserFilterFactory extends MungeSingleTokenFilterFactory {

  public LowerCaserFilterFactory(Map<String, String> args) {
    super(args);
  }

  public LowerCaserFilter create(TokenStream input) {
    return new LowerCaserFilter(input, getEchoInvalidInput());
  }
}
