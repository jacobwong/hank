/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.liveramp.hank.generated;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainGroupMetadata implements org.apache.thrift.TBase<DomainGroupMetadata, DomainGroupMetadata._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DomainGroupMetadata");

  private static final org.apache.thrift.protocol.TField DOMAIN_VERSIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("domain_versions", org.apache.thrift.protocol.TType.MAP, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DomainGroupMetadataStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DomainGroupMetadataTupleSchemeFactory());
  }

  public Map<Integer,Integer> domain_versions; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DOMAIN_VERSIONS((short)1, "domain_versions");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DOMAIN_VERSIONS
          return DOMAIN_VERSIONS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DOMAIN_VERSIONS, new org.apache.thrift.meta_data.FieldMetaData("domain_versions", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DomainGroupMetadata.class, metaDataMap);
  }

  public DomainGroupMetadata() {
  }

  public DomainGroupMetadata(
    Map<Integer,Integer> domain_versions)
  {
    this();
    this.domain_versions = domain_versions;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DomainGroupMetadata(DomainGroupMetadata other) {
    if (other.is_set_domain_versions()) {
      Map<Integer,Integer> __this__domain_versions = new HashMap<Integer,Integer>();
      for (Map.Entry<Integer, Integer> other_element : other.domain_versions.entrySet()) {

        Integer other_element_key = other_element.getKey();
        Integer other_element_value = other_element.getValue();

        Integer __this__domain_versions_copy_key = other_element_key;

        Integer __this__domain_versions_copy_value = other_element_value;

        __this__domain_versions.put(__this__domain_versions_copy_key, __this__domain_versions_copy_value);
      }
      this.domain_versions = __this__domain_versions;
    }
  }

  public DomainGroupMetadata deepCopy() {
    return new DomainGroupMetadata(this);
  }

  @Override
  public void clear() {
    this.domain_versions = null;
  }

  public int get_domain_versions_size() {
    return (this.domain_versions == null) ? 0 : this.domain_versions.size();
  }

  public void put_to_domain_versions(int key, int val) {
    if (this.domain_versions == null) {
      this.domain_versions = new HashMap<Integer,Integer>();
    }
    this.domain_versions.put(key, val);
  }

  public Map<Integer,Integer> get_domain_versions() {
    return this.domain_versions;
  }

  public DomainGroupMetadata set_domain_versions(Map<Integer,Integer> domain_versions) {
    this.domain_versions = domain_versions;
    return this;
  }

  public void unset_domain_versions() {
    this.domain_versions = null;
  }

  /** Returns true if field domain_versions is set (has been assigned a value) and false otherwise */
  public boolean is_set_domain_versions() {
    return this.domain_versions != null;
  }

  public void set_domain_versions_isSet(boolean value) {
    if (!value) {
      this.domain_versions = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DOMAIN_VERSIONS:
      if (value == null) {
        unset_domain_versions();
      } else {
        set_domain_versions((Map<Integer,Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DOMAIN_VERSIONS:
      return get_domain_versions();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DOMAIN_VERSIONS:
      return is_set_domain_versions();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DomainGroupMetadata)
      return this.equals((DomainGroupMetadata)that);
    return false;
  }

  public boolean equals(DomainGroupMetadata that) {
    if (that == null)
      return false;

    boolean this_present_domain_versions = true && this.is_set_domain_versions();
    boolean that_present_domain_versions = true && that.is_set_domain_versions();
    if (this_present_domain_versions || that_present_domain_versions) {
      if (!(this_present_domain_versions && that_present_domain_versions))
        return false;
      if (!this.domain_versions.equals(that.domain_versions))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_domain_versions = true && (is_set_domain_versions());
    builder.append(present_domain_versions);
    if (present_domain_versions)
      builder.append(domain_versions);

    return builder.toHashCode();
  }

  public int compareTo(DomainGroupMetadata other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    DomainGroupMetadata typedOther = (DomainGroupMetadata)other;

    lastComparison = Boolean.valueOf(is_set_domain_versions()).compareTo(typedOther.is_set_domain_versions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_domain_versions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.domain_versions, typedOther.domain_versions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DomainGroupMetadata(");
    boolean first = true;

    sb.append("domain_versions:");
    if (this.domain_versions == null) {
      sb.append("null");
    } else {
      sb.append(this.domain_versions);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (domain_versions == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'domain_versions' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DomainGroupMetadataStandardSchemeFactory implements SchemeFactory {
    public DomainGroupMetadataStandardScheme getScheme() {
      return new DomainGroupMetadataStandardScheme();
    }
  }

  private static class DomainGroupMetadataStandardScheme extends StandardScheme<DomainGroupMetadata> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DomainGroupMetadata struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DOMAIN_VERSIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map18 = iprot.readMapBegin();
                struct.domain_versions = new HashMap<Integer,Integer>(2*_map18.size);
                for (int _i19 = 0; _i19 < _map18.size; ++_i19)
                {
                  int _key20; // required
                  int _val21; // optional
                  _key20 = iprot.readI32();
                  _val21 = iprot.readI32();
                  struct.domain_versions.put(_key20, _val21);
                }
                iprot.readMapEnd();
              }
              struct.set_domain_versions_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DomainGroupMetadata struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.domain_versions != null) {
        oprot.writeFieldBegin(DOMAIN_VERSIONS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I32, struct.domain_versions.size()));
          for (Map.Entry<Integer, Integer> _iter22 : struct.domain_versions.entrySet())
          {
            oprot.writeI32(_iter22.getKey());
            oprot.writeI32(_iter22.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DomainGroupMetadataTupleSchemeFactory implements SchemeFactory {
    public DomainGroupMetadataTupleScheme getScheme() {
      return new DomainGroupMetadataTupleScheme();
    }
  }

  private static class DomainGroupMetadataTupleScheme extends TupleScheme<DomainGroupMetadata> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DomainGroupMetadata struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.domain_versions.size());
        for (Map.Entry<Integer, Integer> _iter23 : struct.domain_versions.entrySet())
        {
          oprot.writeI32(_iter23.getKey());
          oprot.writeI32(_iter23.getValue());
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DomainGroupMetadata struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map24 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.domain_versions = new HashMap<Integer,Integer>(2*_map24.size);
        for (int _i25 = 0; _i25 < _map24.size; ++_i25)
        {
          int _key26; // required
          int _val27; // optional
          _key26 = iprot.readI32();
          _val27 = iprot.readI32();
          struct.domain_versions.put(_key26, _val27);
        }
      }
      struct.set_domain_versions_isSet(true);
    }
  }

}

