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

public class DomainVersionMetadata implements org.apache.thrift.TBase<DomainVersionMetadata, DomainVersionMetadata._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DomainVersionMetadata");

  private static final org.apache.thrift.protocol.TField PROPERTIES_FIELD_DESC = new org.apache.thrift.protocol.TField("properties", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARTITIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("partitions", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField DEFUNCT_FIELD_DESC = new org.apache.thrift.protocol.TField("defunct", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField CLOSED_AT_FIELD_DESC = new org.apache.thrift.protocol.TField("closed_at", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DomainVersionMetadataStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DomainVersionMetadataTupleSchemeFactory());
  }

  public ByteBuffer properties; // required
  public Map<Integer,PartitionMetadata> partitions; // required
  public boolean defunct; // required
  public long closed_at; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PROPERTIES((short)1, "properties"),
    PARTITIONS((short)2, "partitions"),
    DEFUNCT((short)3, "defunct"),
    CLOSED_AT((short)4, "closed_at");

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
        case 1: // PROPERTIES
          return PROPERTIES;
        case 2: // PARTITIONS
          return PARTITIONS;
        case 3: // DEFUNCT
          return DEFUNCT;
        case 4: // CLOSED_AT
          return CLOSED_AT;
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
  private static final int __DEFUNCT_ISSET_ID = 0;
  private static final int __CLOSED_AT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PROPERTIES, new org.apache.thrift.meta_data.FieldMetaData("properties", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.PARTITIONS, new org.apache.thrift.meta_data.FieldMetaData("partitions", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PartitionMetadata.class))));
    tmpMap.put(_Fields.DEFUNCT, new org.apache.thrift.meta_data.FieldMetaData("defunct", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.CLOSED_AT, new org.apache.thrift.meta_data.FieldMetaData("closed_at", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DomainVersionMetadata.class, metaDataMap);
  }

  public DomainVersionMetadata() {
  }

  public DomainVersionMetadata(
    ByteBuffer properties,
    Map<Integer,PartitionMetadata> partitions,
    boolean defunct,
    long closed_at)
  {
    this();
    this.properties = properties;
    this.partitions = partitions;
    this.defunct = defunct;
    set_defunct_isSet(true);
    this.closed_at = closed_at;
    set_closed_at_isSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DomainVersionMetadata(DomainVersionMetadata other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.is_set_properties()) {
      this.properties = org.apache.thrift.TBaseHelper.copyBinary(other.properties);
;
    }
    if (other.is_set_partitions()) {
      Map<Integer,PartitionMetadata> __this__partitions = new HashMap<Integer,PartitionMetadata>();
      for (Map.Entry<Integer, PartitionMetadata> other_element : other.partitions.entrySet()) {

        Integer other_element_key = other_element.getKey();
        PartitionMetadata other_element_value = other_element.getValue();

        Integer __this__partitions_copy_key = other_element_key;

        PartitionMetadata __this__partitions_copy_value = new PartitionMetadata(other_element_value);

        __this__partitions.put(__this__partitions_copy_key, __this__partitions_copy_value);
      }
      this.partitions = __this__partitions;
    }
    this.defunct = other.defunct;
    this.closed_at = other.closed_at;
  }

  public DomainVersionMetadata deepCopy() {
    return new DomainVersionMetadata(this);
  }

  @Override
  public void clear() {
    this.properties = null;
    this.partitions = null;
    set_defunct_isSet(false);
    this.defunct = false;
    set_closed_at_isSet(false);
    this.closed_at = 0;
  }

  public byte[] get_properties() {
    set_properties(org.apache.thrift.TBaseHelper.rightSize(properties));
    return properties == null ? null : properties.array();
  }

  public ByteBuffer buffer_for_properties() {
    return properties;
  }

  public DomainVersionMetadata set_properties(byte[] properties) {
    set_properties(properties == null ? (ByteBuffer)null : ByteBuffer.wrap(properties));
    return this;
  }

  public DomainVersionMetadata set_properties(ByteBuffer properties) {
    this.properties = properties;
    return this;
  }

  public void unset_properties() {
    this.properties = null;
  }

  /** Returns true if field properties is set (has been assigned a value) and false otherwise */
  public boolean is_set_properties() {
    return this.properties != null;
  }

  public void set_properties_isSet(boolean value) {
    if (!value) {
      this.properties = null;
    }
  }

  public int get_partitions_size() {
    return (this.partitions == null) ? 0 : this.partitions.size();
  }

  public void put_to_partitions(int key, PartitionMetadata val) {
    if (this.partitions == null) {
      this.partitions = new HashMap<Integer,PartitionMetadata>();
    }
    this.partitions.put(key, val);
  }

  public Map<Integer,PartitionMetadata> get_partitions() {
    return this.partitions;
  }

  public DomainVersionMetadata set_partitions(Map<Integer,PartitionMetadata> partitions) {
    this.partitions = partitions;
    return this;
  }

  public void unset_partitions() {
    this.partitions = null;
  }

  /** Returns true if field partitions is set (has been assigned a value) and false otherwise */
  public boolean is_set_partitions() {
    return this.partitions != null;
  }

  public void set_partitions_isSet(boolean value) {
    if (!value) {
      this.partitions = null;
    }
  }

  public boolean is_defunct() {
    return this.defunct;
  }

  public DomainVersionMetadata set_defunct(boolean defunct) {
    this.defunct = defunct;
    set_defunct_isSet(true);
    return this;
  }

  public void unset_defunct() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DEFUNCT_ISSET_ID);
  }

  /** Returns true if field defunct is set (has been assigned a value) and false otherwise */
  public boolean is_set_defunct() {
    return EncodingUtils.testBit(__isset_bitfield, __DEFUNCT_ISSET_ID);
  }

  public void set_defunct_isSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DEFUNCT_ISSET_ID, value);
  }

  public long get_closed_at() {
    return this.closed_at;
  }

  public DomainVersionMetadata set_closed_at(long closed_at) {
    this.closed_at = closed_at;
    set_closed_at_isSet(true);
    return this;
  }

  public void unset_closed_at() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CLOSED_AT_ISSET_ID);
  }

  /** Returns true if field closed_at is set (has been assigned a value) and false otherwise */
  public boolean is_set_closed_at() {
    return EncodingUtils.testBit(__isset_bitfield, __CLOSED_AT_ISSET_ID);
  }

  public void set_closed_at_isSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CLOSED_AT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PROPERTIES:
      if (value == null) {
        unset_properties();
      } else {
        set_properties((ByteBuffer)value);
      }
      break;

    case PARTITIONS:
      if (value == null) {
        unset_partitions();
      } else {
        set_partitions((Map<Integer,PartitionMetadata>)value);
      }
      break;

    case DEFUNCT:
      if (value == null) {
        unset_defunct();
      } else {
        set_defunct((Boolean)value);
      }
      break;

    case CLOSED_AT:
      if (value == null) {
        unset_closed_at();
      } else {
        set_closed_at((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PROPERTIES:
      return get_properties();

    case PARTITIONS:
      return get_partitions();

    case DEFUNCT:
      return Boolean.valueOf(is_defunct());

    case CLOSED_AT:
      return Long.valueOf(get_closed_at());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PROPERTIES:
      return is_set_properties();
    case PARTITIONS:
      return is_set_partitions();
    case DEFUNCT:
      return is_set_defunct();
    case CLOSED_AT:
      return is_set_closed_at();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DomainVersionMetadata)
      return this.equals((DomainVersionMetadata)that);
    return false;
  }

  public boolean equals(DomainVersionMetadata that) {
    if (that == null)
      return false;

    boolean this_present_properties = true && this.is_set_properties();
    boolean that_present_properties = true && that.is_set_properties();
    if (this_present_properties || that_present_properties) {
      if (!(this_present_properties && that_present_properties))
        return false;
      if (!this.properties.equals(that.properties))
        return false;
    }

    boolean this_present_partitions = true && this.is_set_partitions();
    boolean that_present_partitions = true && that.is_set_partitions();
    if (this_present_partitions || that_present_partitions) {
      if (!(this_present_partitions && that_present_partitions))
        return false;
      if (!this.partitions.equals(that.partitions))
        return false;
    }

    boolean this_present_defunct = true;
    boolean that_present_defunct = true;
    if (this_present_defunct || that_present_defunct) {
      if (!(this_present_defunct && that_present_defunct))
        return false;
      if (this.defunct != that.defunct)
        return false;
    }

    boolean this_present_closed_at = true;
    boolean that_present_closed_at = true;
    if (this_present_closed_at || that_present_closed_at) {
      if (!(this_present_closed_at && that_present_closed_at))
        return false;
      if (this.closed_at != that.closed_at)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_properties = true && (is_set_properties());
    builder.append(present_properties);
    if (present_properties)
      builder.append(properties);

    boolean present_partitions = true && (is_set_partitions());
    builder.append(present_partitions);
    if (present_partitions)
      builder.append(partitions);

    boolean present_defunct = true;
    builder.append(present_defunct);
    if (present_defunct)
      builder.append(defunct);

    boolean present_closed_at = true;
    builder.append(present_closed_at);
    if (present_closed_at)
      builder.append(closed_at);

    return builder.toHashCode();
  }

  public int compareTo(DomainVersionMetadata other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    DomainVersionMetadata typedOther = (DomainVersionMetadata)other;

    lastComparison = Boolean.valueOf(is_set_properties()).compareTo(typedOther.is_set_properties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_properties()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.properties, typedOther.properties);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_partitions()).compareTo(typedOther.is_set_partitions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_partitions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitions, typedOther.partitions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_defunct()).compareTo(typedOther.is_set_defunct());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_defunct()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defunct, typedOther.defunct);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_closed_at()).compareTo(typedOther.is_set_closed_at());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_closed_at()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.closed_at, typedOther.closed_at);
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
    StringBuilder sb = new StringBuilder("DomainVersionMetadata(");
    boolean first = true;

    sb.append("properties:");
    if (this.properties == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.properties, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("partitions:");
    if (this.partitions == null) {
      sb.append("null");
    } else {
      sb.append(this.partitions);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("defunct:");
    sb.append(this.defunct);
    first = false;
    if (!first) sb.append(", ");
    sb.append("closed_at:");
    sb.append(this.closed_at);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (partitions == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'partitions' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'defunct' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'closed_at' because it's a primitive and you chose the non-beans generator.
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DomainVersionMetadataStandardSchemeFactory implements SchemeFactory {
    public DomainVersionMetadataStandardScheme getScheme() {
      return new DomainVersionMetadataStandardScheme();
    }
  }

  private static class DomainVersionMetadataStandardScheme extends StandardScheme<DomainVersionMetadata> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DomainVersionMetadata struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROPERTIES
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.properties = iprot.readBinary();
              struct.set_properties_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARTITIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map8 = iprot.readMapBegin();
                struct.partitions = new HashMap<Integer,PartitionMetadata>(2*_map8.size);
                for (int _i9 = 0; _i9 < _map8.size; ++_i9)
                {
                  int _key10; // required
                  PartitionMetadata _val11; // optional
                  _key10 = iprot.readI32();
                  _val11 = new PartitionMetadata();
                  _val11.read(iprot);
                  struct.partitions.put(_key10, _val11);
                }
                iprot.readMapEnd();
              }
              struct.set_partitions_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEFUNCT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.defunct = iprot.readBool();
              struct.set_defunct_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CLOSED_AT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.closed_at = iprot.readI64();
              struct.set_closed_at_isSet(true);
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
      if (!struct.is_set_defunct()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'defunct' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.is_set_closed_at()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'closed_at' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DomainVersionMetadata struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.properties != null) {
        oprot.writeFieldBegin(PROPERTIES_FIELD_DESC);
        oprot.writeBinary(struct.properties);
        oprot.writeFieldEnd();
      }
      if (struct.partitions != null) {
        oprot.writeFieldBegin(PARTITIONS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, struct.partitions.size()));
          for (Map.Entry<Integer, PartitionMetadata> _iter12 : struct.partitions.entrySet())
          {
            oprot.writeI32(_iter12.getKey());
            _iter12.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(DEFUNCT_FIELD_DESC);
      oprot.writeBool(struct.defunct);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CLOSED_AT_FIELD_DESC);
      oprot.writeI64(struct.closed_at);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DomainVersionMetadataTupleSchemeFactory implements SchemeFactory {
    public DomainVersionMetadataTupleScheme getScheme() {
      return new DomainVersionMetadataTupleScheme();
    }
  }

  private static class DomainVersionMetadataTupleScheme extends TupleScheme<DomainVersionMetadata> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DomainVersionMetadata struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.partitions.size());
        for (Map.Entry<Integer, PartitionMetadata> _iter13 : struct.partitions.entrySet())
        {
          oprot.writeI32(_iter13.getKey());
          _iter13.getValue().write(oprot);
        }
      }
      oprot.writeBool(struct.defunct);
      oprot.writeI64(struct.closed_at);
      BitSet optionals = new BitSet();
      if (struct.is_set_properties()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.is_set_properties()) {
        oprot.writeBinary(struct.properties);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DomainVersionMetadata struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map14 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.partitions = new HashMap<Integer,PartitionMetadata>(2*_map14.size);
        for (int _i15 = 0; _i15 < _map14.size; ++_i15)
        {
          int _key16; // required
          PartitionMetadata _val17; // optional
          _key16 = iprot.readI32();
          _val17 = new PartitionMetadata();
          _val17.read(iprot);
          struct.partitions.put(_key16, _val17);
        }
      }
      struct.set_partitions_isSet(true);
      struct.defunct = iprot.readBool();
      struct.set_defunct_isSet(true);
      struct.closed_at = iprot.readI64();
      struct.set_closed_at_isSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.properties = iprot.readBinary();
        struct.set_properties_isSet(true);
      }
    }
  }

}

