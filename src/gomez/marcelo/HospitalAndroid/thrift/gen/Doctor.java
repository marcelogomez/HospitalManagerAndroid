package gomez.marcelo.HospitalAndroid.thrift.gen; /**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class Doctor implements org.apache.thrift.TBase<Doctor, Doctor._Fields>, java.io.Serializable, Cloneable, Comparable<Doctor> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Doctor");

  private static final org.apache.thrift.protocol.TField CLAVE_FIELD_DESC = new org.apache.thrift.protocol.TField("clave", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField NOMBRE_FIELD_DESC = new org.apache.thrift.protocol.TField("nombre", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DIRECCION_FIELD_DESC = new org.apache.thrift.protocol.TField("direccion", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ESPECIALIDAD_FIELD_DESC = new org.apache.thrift.protocol.TField("especialidad", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TELEFONO_FIELD_DESC = new org.apache.thrift.protocol.TField("telefono", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField FOTO_FIELD_DESC = new org.apache.thrift.protocol.TField("foto", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DoctorStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DoctorTupleSchemeFactory());
  }

  public String clave; // required
  public String nombre; // required
  public String direccion; // required
  public String especialidad; // required
  public String telefono; // required
  public String foto; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CLAVE((short)1, "clave"),
    NOMBRE((short)2, "nombre"),
    DIRECCION((short)3, "direccion"),
    ESPECIALIDAD((short)4, "especialidad"),
    TELEFONO((short)5, "telefono"),
    FOTO((short)6, "foto");

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
        case 1: // CLAVE
          return CLAVE;
        case 2: // NOMBRE
          return NOMBRE;
        case 3: // DIRECCION
          return DIRECCION;
        case 4: // ESPECIALIDAD
          return ESPECIALIDAD;
        case 5: // TELEFONO
          return TELEFONO;
        case 6: // FOTO
          return FOTO;
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
    tmpMap.put(_Fields.CLAVE, new org.apache.thrift.meta_data.FieldMetaData("clave", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NOMBRE, new org.apache.thrift.meta_data.FieldMetaData("nombre", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DIRECCION, new org.apache.thrift.meta_data.FieldMetaData("direccion", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ESPECIALIDAD, new org.apache.thrift.meta_data.FieldMetaData("especialidad", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TELEFONO, new org.apache.thrift.meta_data.FieldMetaData("telefono", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FOTO, new org.apache.thrift.meta_data.FieldMetaData("foto", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Doctor.class, metaDataMap);
  }

  public Doctor() {
  }

  public Doctor(
    String clave,
    String nombre,
    String direccion,
    String especialidad,
    String telefono,
    String foto)
  {
    this();
    this.clave = clave;
    this.nombre = nombre;
    this.direccion = direccion;
    this.especialidad = especialidad;
    this.telefono = telefono;
    this.foto = foto;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Doctor(Doctor other) {
    if (other.isSetClave()) {
      this.clave = other.clave;
    }
    if (other.isSetNombre()) {
      this.nombre = other.nombre;
    }
    if (other.isSetDireccion()) {
      this.direccion = other.direccion;
    }
    if (other.isSetEspecialidad()) {
      this.especialidad = other.especialidad;
    }
    if (other.isSetTelefono()) {
      this.telefono = other.telefono;
    }
    if (other.isSetFoto()) {
      this.foto = other.foto;
    }
  }

  public Doctor deepCopy() {
    return new Doctor(this);
  }

  @Override
  public void clear() {
    this.clave = null;
    this.nombre = null;
    this.direccion = null;
    this.especialidad = null;
    this.telefono = null;
    this.foto = null;
  }

  public String getClave() {
    return this.clave;
  }

  public Doctor setClave(String clave) {
    this.clave = clave;
    return this;
  }

  public void unsetClave() {
    this.clave = null;
  }

  /** Returns true if field clave is set (has been assigned a value) and false otherwise */
  public boolean isSetClave() {
    return this.clave != null;
  }

  public void setClaveIsSet(boolean value) {
    if (!value) {
      this.clave = null;
    }
  }

  public String getNombre() {
    return this.nombre;
  }

  public Doctor setNombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  public void unsetNombre() {
    this.nombre = null;
  }

  /** Returns true if field nombre is set (has been assigned a value) and false otherwise */
  public boolean isSetNombre() {
    return this.nombre != null;
  }

  public void setNombreIsSet(boolean value) {
    if (!value) {
      this.nombre = null;
    }
  }

  public String getDireccion() {
    return this.direccion;
  }

  public Doctor setDireccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  public void unsetDireccion() {
    this.direccion = null;
  }

  /** Returns true if field direccion is set (has been assigned a value) and false otherwise */
  public boolean isSetDireccion() {
    return this.direccion != null;
  }

  public void setDireccionIsSet(boolean value) {
    if (!value) {
      this.direccion = null;
    }
  }

  public String getEspecialidad() {
    return this.especialidad;
  }

  public Doctor setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
    return this;
  }

  public void unsetEspecialidad() {
    this.especialidad = null;
  }

  /** Returns true if field especialidad is set (has been assigned a value) and false otherwise */
  public boolean isSetEspecialidad() {
    return this.especialidad != null;
  }

  public void setEspecialidadIsSet(boolean value) {
    if (!value) {
      this.especialidad = null;
    }
  }

  public String getTelefono() {
    return this.telefono;
  }

  public Doctor setTelefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  public void unsetTelefono() {
    this.telefono = null;
  }

  /** Returns true if field telefono is set (has been assigned a value) and false otherwise */
  public boolean isSetTelefono() {
    return this.telefono != null;
  }

  public void setTelefonoIsSet(boolean value) {
    if (!value) {
      this.telefono = null;
    }
  }

  public String getFoto() {
    return this.foto;
  }

  public Doctor setFoto(String foto) {
    this.foto = foto;
    return this;
  }

  public void unsetFoto() {
    this.foto = null;
  }

  /** Returns true if field foto is set (has been assigned a value) and false otherwise */
  public boolean isSetFoto() {
    return this.foto != null;
  }

  public void setFotoIsSet(boolean value) {
    if (!value) {
      this.foto = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CLAVE:
      if (value == null) {
        unsetClave();
      } else {
        setClave((String)value);
      }
      break;

    case NOMBRE:
      if (value == null) {
        unsetNombre();
      } else {
        setNombre((String)value);
      }
      break;

    case DIRECCION:
      if (value == null) {
        unsetDireccion();
      } else {
        setDireccion((String)value);
      }
      break;

    case ESPECIALIDAD:
      if (value == null) {
        unsetEspecialidad();
      } else {
        setEspecialidad((String)value);
      }
      break;

    case TELEFONO:
      if (value == null) {
        unsetTelefono();
      } else {
        setTelefono((String)value);
      }
      break;

    case FOTO:
      if (value == null) {
        unsetFoto();
      } else {
        setFoto((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLAVE:
      return getClave();

    case NOMBRE:
      return getNombre();

    case DIRECCION:
      return getDireccion();

    case ESPECIALIDAD:
      return getEspecialidad();

    case TELEFONO:
      return getTelefono();

    case FOTO:
      return getFoto();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CLAVE:
      return isSetClave();
    case NOMBRE:
      return isSetNombre();
    case DIRECCION:
      return isSetDireccion();
    case ESPECIALIDAD:
      return isSetEspecialidad();
    case TELEFONO:
      return isSetTelefono();
    case FOTO:
      return isSetFoto();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Doctor)
      return this.equals((Doctor)that);
    return false;
  }

  public boolean equals(Doctor that) {
    if (that == null)
      return false;

    boolean this_present_clave = true && this.isSetClave();
    boolean that_present_clave = true && that.isSetClave();
    if (this_present_clave || that_present_clave) {
      if (!(this_present_clave && that_present_clave))
        return false;
      if (!this.clave.equals(that.clave))
        return false;
    }

    boolean this_present_nombre = true && this.isSetNombre();
    boolean that_present_nombre = true && that.isSetNombre();
    if (this_present_nombre || that_present_nombre) {
      if (!(this_present_nombre && that_present_nombre))
        return false;
      if (!this.nombre.equals(that.nombre))
        return false;
    }

    boolean this_present_direccion = true && this.isSetDireccion();
    boolean that_present_direccion = true && that.isSetDireccion();
    if (this_present_direccion || that_present_direccion) {
      if (!(this_present_direccion && that_present_direccion))
        return false;
      if (!this.direccion.equals(that.direccion))
        return false;
    }

    boolean this_present_especialidad = true && this.isSetEspecialidad();
    boolean that_present_especialidad = true && that.isSetEspecialidad();
    if (this_present_especialidad || that_present_especialidad) {
      if (!(this_present_especialidad && that_present_especialidad))
        return false;
      if (!this.especialidad.equals(that.especialidad))
        return false;
    }

    boolean this_present_telefono = true && this.isSetTelefono();
    boolean that_present_telefono = true && that.isSetTelefono();
    if (this_present_telefono || that_present_telefono) {
      if (!(this_present_telefono && that_present_telefono))
        return false;
      if (!this.telefono.equals(that.telefono))
        return false;
    }

    boolean this_present_foto = true && this.isSetFoto();
    boolean that_present_foto = true && that.isSetFoto();
    if (this_present_foto || that_present_foto) {
      if (!(this_present_foto && that_present_foto))
        return false;
      if (!this.foto.equals(that.foto))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Doctor other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetClave()).compareTo(other.isSetClave());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClave()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clave, other.clave);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNombre()).compareTo(other.isSetNombre());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNombre()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nombre, other.nombre);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDireccion()).compareTo(other.isSetDireccion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDireccion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.direccion, other.direccion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEspecialidad()).compareTo(other.isSetEspecialidad());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEspecialidad()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.especialidad, other.especialidad);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTelefono()).compareTo(other.isSetTelefono());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTelefono()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.telefono, other.telefono);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFoto()).compareTo(other.isSetFoto());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFoto()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.foto, other.foto);
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
    StringBuilder sb = new StringBuilder("Doctor(");
    boolean first = true;

    sb.append("clave:");
    if (this.clave == null) {
      sb.append("null");
    } else {
      sb.append(this.clave);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nombre:");
    if (this.nombre == null) {
      sb.append("null");
    } else {
      sb.append(this.nombre);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("direccion:");
    if (this.direccion == null) {
      sb.append("null");
    } else {
      sb.append(this.direccion);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("especialidad:");
    if (this.especialidad == null) {
      sb.append("null");
    } else {
      sb.append(this.especialidad);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("telefono:");
    if (this.telefono == null) {
      sb.append("null");
    } else {
      sb.append(this.telefono);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("foto:");
    if (this.foto == null) {
      sb.append("null");
    } else {
      sb.append(this.foto);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class DoctorStandardSchemeFactory implements SchemeFactory {
    public DoctorStandardScheme getScheme() {
      return new DoctorStandardScheme();
    }
  }

  private static class DoctorStandardScheme extends StandardScheme<Doctor> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Doctor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLAVE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.clave = iprot.readString();
              struct.setClaveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NOMBRE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.nombre = iprot.readString();
              struct.setNombreIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DIRECCION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.direccion = iprot.readString();
              struct.setDireccionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ESPECIALIDAD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.especialidad = iprot.readString();
              struct.setEspecialidadIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TELEFONO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.telefono = iprot.readString();
              struct.setTelefonoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // FOTO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.foto = iprot.readString();
              struct.setFotoIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Doctor struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.clave != null) {
        oprot.writeFieldBegin(CLAVE_FIELD_DESC);
        oprot.writeString(struct.clave);
        oprot.writeFieldEnd();
      }
      if (struct.nombre != null) {
        oprot.writeFieldBegin(NOMBRE_FIELD_DESC);
        oprot.writeString(struct.nombre);
        oprot.writeFieldEnd();
      }
      if (struct.direccion != null) {
        oprot.writeFieldBegin(DIRECCION_FIELD_DESC);
        oprot.writeString(struct.direccion);
        oprot.writeFieldEnd();
      }
      if (struct.especialidad != null) {
        oprot.writeFieldBegin(ESPECIALIDAD_FIELD_DESC);
        oprot.writeString(struct.especialidad);
        oprot.writeFieldEnd();
      }
      if (struct.telefono != null) {
        oprot.writeFieldBegin(TELEFONO_FIELD_DESC);
        oprot.writeString(struct.telefono);
        oprot.writeFieldEnd();
      }
      if (struct.foto != null) {
        oprot.writeFieldBegin(FOTO_FIELD_DESC);
        oprot.writeString(struct.foto);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DoctorTupleSchemeFactory implements SchemeFactory {
    public DoctorTupleScheme getScheme() {
      return new DoctorTupleScheme();
    }
  }

  private static class DoctorTupleScheme extends TupleScheme<Doctor> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Doctor struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetClave()) {
        optionals.set(0);
      }
      if (struct.isSetNombre()) {
        optionals.set(1);
      }
      if (struct.isSetDireccion()) {
        optionals.set(2);
      }
      if (struct.isSetEspecialidad()) {
        optionals.set(3);
      }
      if (struct.isSetTelefono()) {
        optionals.set(4);
      }
      if (struct.isSetFoto()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetClave()) {
        oprot.writeString(struct.clave);
      }
      if (struct.isSetNombre()) {
        oprot.writeString(struct.nombre);
      }
      if (struct.isSetDireccion()) {
        oprot.writeString(struct.direccion);
      }
      if (struct.isSetEspecialidad()) {
        oprot.writeString(struct.especialidad);
      }
      if (struct.isSetTelefono()) {
        oprot.writeString(struct.telefono);
      }
      if (struct.isSetFoto()) {
        oprot.writeString(struct.foto);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Doctor struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.clave = iprot.readString();
        struct.setClaveIsSet(true);
      }
      if (incoming.get(1)) {
        struct.nombre = iprot.readString();
        struct.setNombreIsSet(true);
      }
      if (incoming.get(2)) {
        struct.direccion = iprot.readString();
        struct.setDireccionIsSet(true);
      }
      if (incoming.get(3)) {
        struct.especialidad = iprot.readString();
        struct.setEspecialidadIsSet(true);
      }
      if (incoming.get(4)) {
        struct.telefono = iprot.readString();
        struct.setTelefonoIsSet(true);
      }
      if (incoming.get(5)) {
        struct.foto = iprot.readString();
        struct.setFotoIsSet(true);
      }
    }
  }

}

