package com.billdueber.solr_scaffold.schema;

import org.apache.solr.common.SolrException;
import org.apache.solr.schema.IndexSchema;
import org.apache.solr.schema.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.Map;

public class StringCopiedFromTextField extends StringMungedIndexMungedStored {

  String fieldName;
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  protected void init(IndexSchema schema, Map<String, String> args) throws SolrException {
    super.init(schema, args);
    String p = args.remove("echoInvalidInput");
    fieldName = args.remove("fieldName");
    if (p != null) {
      this.echoInvalidInput = Boolean.parseBoolean(p);
    }
    if (fieldName == null) {
      throw new SolrException(
          SolrException.ErrorCode.BAD_REQUEST,
          this.getClass().toString() + " needs a fieldName attribute");
    }
  }

  @Override
  public String toInternal(String val) {
    try {
      TextField ft = (TextField) sch.getFieldType(fieldName);
      return TextField.analyzeMultiTerm(fieldName, val, ft.getIndexAnalyzer()).utf8ToString();
    } catch(SolrException e) {
      throw new SolrException(SolrException.ErrorCode.BAD_REQUEST, "Can't create fieldType " + this.typeName + "; field " + fieldName + " doesn't exist");
    }
  }
}
