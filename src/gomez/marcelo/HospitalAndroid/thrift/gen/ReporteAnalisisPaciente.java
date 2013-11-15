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

public class ReporteAnalisisPaciente implements org.apache.thrift.TBase<ReporteAnalisisPaciente, ReporteAnalisisPaciente._Fields>, java.io.Serializable, Cloneable, Comparable<ReporteAnalisisPaciente> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReporteAnalisisPaciente");

  private static final org.apache.thrift.protocol.TField CLAVE_PACIENTE_FIELD_DESC = new org.apache.thrift.protocol.TField("clavePaciente", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CLAVE_ANALISIS_FIELD_DESC = new org.apache.thrift.protocol.TField("claveAnalisis", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FECHA_APLIC_FIELD_DESC = new org.apache.thrift.protocol.TField("fechaAplic", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NOMBRE_PACIENTE_FIELD_DESC = new org.apache.thrift.protocol.TField("nombrePaciente", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField FECHAENTREGA_FIELD_DESC = new org.apache.thrift.protocol.TField("fechaentrega", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField TIPO_FIELD_DESC = new org.apache.thrift.protocol.TField("tipo", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField DESCRIPCION_FIELD_DESC = new org.apache.thrift.protocol.TField("descripcion", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField FOTO_PACIENTE_FIELD_DESC = new org.apache.thrift.protocol.TField("fotoPaciente", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReporteAnalisisPacienteStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReporteAnalisisPacienteTupleSchemeFactory());
  }

  public String clavePaciente; // required
  public String claveAnalisis; // required
  public String fechaAplic; // required
  public String nombrePaciente; // required
  public String fechaentrega; // required
  public String tipo; // required
  public String descripcion; // required
  public String fotoPaciente; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CLAVE_PACIENTE((short)1, "clavePaciente"),
    CLAVE_ANALISIS((short)2, "claveAnalisis"),
    FECHA_APLIC((short)3, "fechaAplic"),
    NOMBRE_PACIENTE((short)4, "nombrePaciente"),
    FECHAENTREGA((short)5, "fechaentrega"),
    TIPO((short)6, "tipo"),
    DESCRIPCION((short)7, "descripcion"),
    FOTO_PACIENTE((short)8, "fotoPaciente");

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
        case 1: // CLAVE_PACIENTE
          return CLAVE_PACIENTE;
        case 2: // CLAVE_ANALISIS
          return CLAVE_ANALISIS;
        case 3: // FECHA_APLIC
          return FECHA_APLIC;
        case 4: // NOMBRE_PACIENTE
          return NOMBRE_PACIENTE;
        case 5: // FECHAENTREGA
          return FECHAENTREGA;
        case 6: // TIPO
          return TIPO;
        case 7: // DESCRIPCION
          return DESCRIPCION;
        case 8: // FOTO_PACIENTE
          return FOTO_PACIENTE;
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
    tmpMap.put(_Fields.CLAVE_PACIENTE, new org.apache.thrift.meta_data.FieldMetaData("clavePaciente", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CLAVE_ANALISIS, new org.apache.thrift.meta_data.FieldMetaData("claveAnalisis", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FECHA_APLIC, new org.apache.thrift.meta_data.FieldMetaData("fechaAplic", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NOMBRE_PACIENTE, new org.apache.thrift.meta_data.FieldMetaData("nombrePaciente", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FECHAENTREGA, new org.apache.thrift.meta_data.FieldMetaData("fechaentrega", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TIPO, new org.apache.thrift.meta_data.FieldMetaData("tipo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESCRIPCION, new org.apache.thrift.meta_data.FieldMetaData("descripcion", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FOTO_PACIENTE, new org.apache.thrift.meta_data.FieldMetaData("fotoPaciente", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReporteAnalisisPaciente.class, metaDataMap);
  }

  public ReporteAnalisisPaciente() {
  }

  public ReporteAnalisisPaciente(
    String clavePaciente,
    String claveAnalisis,
    String fechaAplic,
    String nombrePaciente,
    String fechaentrega,
    String tipo,
    String descripcion,
    String fotoPaciente)
  {
    this();
    this.clavePaciente = clavePaciente;
    this.claveAnalisis = claveAnalisis;
    this.fechaAplic = fechaAplic;
    this.nombrePaciente = nombrePaciente;
    this.fechaentrega = fechaentrega;
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.fotoPaciente = fotoPaciente;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReporteAnalisisPaciente(ReporteAnalisisPaciente other) {
    if (other.isSetClavePaciente()) {
      this.clavePaciente = other.clavePaciente;
    }
    if (other.isSetClaveAnalisis()) {
      this.claveAnalisis = other.claveAnalisis;
    }
    if (other.isSetFechaAplic()) {
      this.fechaAplic = other.fechaAplic;
    }
    if (other.isSetNombrePaciente()) {
      this.nombrePaciente = other.nombrePaciente;
    }
    if (other.isSetFechaentrega()) {
      this.fechaentrega = other.fechaentrega;
    }
    if (other.isSetTipo()) {
      this.tipo = other.tipo;
    }
    if (other.isSetDescripcion()) {
      this.descripcion = other.descripcion;
    }
    if (other.isSetFotoPaciente()) {
      this.fotoPaciente = other.fotoPaciente;
    }
  }

  public ReporteAnalisisPaciente deepCopy() {
    return new ReporteAnalisisPaciente(this);
  }

  @Override
  public void clear() {
    this.clavePaciente = null;
    this.claveAnalisis = null;
    this.fechaAplic = null;
    this.nombrePaciente = null;
    this.fechaentrega = null;
    this.tipo = null;
    this.descripcion = null;
    this.fotoPaciente = null;
  }

  public String getClavePaciente() {
    return this.clavePaciente;
  }

  public ReporteAnalisisPaciente setClavePaciente(String clavePaciente) {
    this.clavePaciente = clavePaciente;
    return this;
  }

  public void unsetClavePaciente() {
    this.clavePaciente = null;
  }

  /** Returns true if field clavePaciente is set (has been assigned a value) and false otherwise */
  public boolean isSetClavePaciente() {
    return this.clavePaciente != null;
  }

  public void setClavePacienteIsSet(boolean value) {
    if (!value) {
      this.clavePaciente = null;
    }
  }

  public String getClaveAnalisis() {
    return this.claveAnalisis;
  }

  public ReporteAnalisisPaciente setClaveAnalisis(String claveAnalisis) {
    this.claveAnalisis = claveAnalisis;
    return this;
  }

  public void unsetClaveAnalisis() {
    this.claveAnalisis = null;
  }

  /** Returns true if field claveAnalisis is set (has been assigned a value) and false otherwise */
  public boolean isSetClaveAnalisis() {
    return this.claveAnalisis != null;
  }

  public void setClaveAnalisisIsSet(boolean value) {
    if (!value) {
      this.claveAnalisis = null;
    }
  }

  public String getFechaAplic() {
    return this.fechaAplic;
  }

  public ReporteAnalisisPaciente setFechaAplic(String fechaAplic) {
    this.fechaAplic = fechaAplic;
    return this;
  }

  public void unsetFechaAplic() {
    this.fechaAplic = null;
  }

  /** Returns true if field fechaAplic is set (has been assigned a value) and false otherwise */
  public boolean isSetFechaAplic() {
    return this.fechaAplic != null;
  }

  public void setFechaAplicIsSet(boolean value) {
    if (!value) {
      this.fechaAplic = null;
    }
  }

  public String getNombrePaciente() {
    return this.nombrePaciente;
  }

  public ReporteAnalisisPaciente setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
    return this;
  }

  public void unsetNombrePaciente() {
    this.nombrePaciente = null;
  }

  /** Returns true if field nombrePaciente is set (has been assigned a value) and false otherwise */
  public boolean isSetNombrePaciente() {
    return this.nombrePaciente != null;
  }

  public void setNombrePacienteIsSet(boolean value) {
    if (!value) {
      this.nombrePaciente = null;
    }
  }

  public String getFechaentrega() {
    return this.fechaentrega;
  }

  public ReporteAnalisisPaciente setFechaentrega(String fechaentrega) {
    this.fechaentrega = fechaentrega;
    return this;
  }

  public void unsetFechaentrega() {
    this.fechaentrega = null;
  }

  /** Returns true if field fechaentrega is set (has been assigned a value) and false otherwise */
  public boolean isSetFechaentrega() {
    return this.fechaentrega != null;
  }

  public void setFechaentregaIsSet(boolean value) {
    if (!value) {
      this.fechaentrega = null;
    }
  }

  public String getTipo() {
    return this.tipo;
  }

  public ReporteAnalisisPaciente setTipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  public void unsetTipo() {
    this.tipo = null;
  }

  /** Returns true if field tipo is set (has been assigned a value) and false otherwise */
  public boolean isSetTipo() {
    return this.tipo != null;
  }

  public void setTipoIsSet(boolean value) {
    if (!value) {
      this.tipo = null;
    }
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public ReporteAnalisisPaciente setDescripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  public void unsetDescripcion() {
    this.descripcion = null;
  }

  /** Returns true if field descripcion is set (has been assigned a value) and false otherwise */
  public boolean isSetDescripcion() {
    return this.descripcion != null;
  }

  public void setDescripcionIsSet(boolean value) {
    if (!value) {
      this.descripcion = null;
    }
  }

  public String getFotoPaciente() {
    return this.fotoPaciente;
  }

  public ReporteAnalisisPaciente setFotoPaciente(String fotoPaciente) {
    this.fotoPaciente = fotoPaciente;
    return this;
  }

  public void unsetFotoPaciente() {
    this.fotoPaciente = null;
  }

  /** Returns true if field fotoPaciente is set (has been assigned a value) and false otherwise */
  public boolean isSetFotoPaciente() {
    return this.fotoPaciente != null;
  }

  public void setFotoPacienteIsSet(boolean value) {
    if (!value) {
      this.fotoPaciente = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CLAVE_PACIENTE:
      if (value == null) {
        unsetClavePaciente();
      } else {
        setClavePaciente((String)value);
      }
      break;

    case CLAVE_ANALISIS:
      if (value == null) {
        unsetClaveAnalisis();
      } else {
        setClaveAnalisis((String)value);
      }
      break;

    case FECHA_APLIC:
      if (value == null) {
        unsetFechaAplic();
      } else {
        setFechaAplic((String)value);
      }
      break;

    case NOMBRE_PACIENTE:
      if (value == null) {
        unsetNombrePaciente();
      } else {
        setNombrePaciente((String)value);
      }
      break;

    case FECHAENTREGA:
      if (value == null) {
        unsetFechaentrega();
      } else {
        setFechaentrega((String)value);
      }
      break;

    case TIPO:
      if (value == null) {
        unsetTipo();
      } else {
        setTipo((String)value);
      }
      break;

    case DESCRIPCION:
      if (value == null) {
        unsetDescripcion();
      } else {
        setDescripcion((String)value);
      }
      break;

    case FOTO_PACIENTE:
      if (value == null) {
        unsetFotoPaciente();
      } else {
        setFotoPaciente((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLAVE_PACIENTE:
      return getClavePaciente();

    case CLAVE_ANALISIS:
      return getClaveAnalisis();

    case FECHA_APLIC:
      return getFechaAplic();

    case NOMBRE_PACIENTE:
      return getNombrePaciente();

    case FECHAENTREGA:
      return getFechaentrega();

    case TIPO:
      return getTipo();

    case DESCRIPCION:
      return getDescripcion();

    case FOTO_PACIENTE:
      return getFotoPaciente();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CLAVE_PACIENTE:
      return isSetClavePaciente();
    case CLAVE_ANALISIS:
      return isSetClaveAnalisis();
    case FECHA_APLIC:
      return isSetFechaAplic();
    case NOMBRE_PACIENTE:
      return isSetNombrePaciente();
    case FECHAENTREGA:
      return isSetFechaentrega();
    case TIPO:
      return isSetTipo();
    case DESCRIPCION:
      return isSetDescripcion();
    case FOTO_PACIENTE:
      return isSetFotoPaciente();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReporteAnalisisPaciente)
      return this.equals((ReporteAnalisisPaciente)that);
    return false;
  }

  public boolean equals(ReporteAnalisisPaciente that) {
    if (that == null)
      return false;

    boolean this_present_clavePaciente = true && this.isSetClavePaciente();
    boolean that_present_clavePaciente = true && that.isSetClavePaciente();
    if (this_present_clavePaciente || that_present_clavePaciente) {
      if (!(this_present_clavePaciente && that_present_clavePaciente))
        return false;
      if (!this.clavePaciente.equals(that.clavePaciente))
        return false;
    }

    boolean this_present_claveAnalisis = true && this.isSetClaveAnalisis();
    boolean that_present_claveAnalisis = true && that.isSetClaveAnalisis();
    if (this_present_claveAnalisis || that_present_claveAnalisis) {
      if (!(this_present_claveAnalisis && that_present_claveAnalisis))
        return false;
      if (!this.claveAnalisis.equals(that.claveAnalisis))
        return false;
    }

    boolean this_present_fechaAplic = true && this.isSetFechaAplic();
    boolean that_present_fechaAplic = true && that.isSetFechaAplic();
    if (this_present_fechaAplic || that_present_fechaAplic) {
      if (!(this_present_fechaAplic && that_present_fechaAplic))
        return false;
      if (!this.fechaAplic.equals(that.fechaAplic))
        return false;
    }

    boolean this_present_nombrePaciente = true && this.isSetNombrePaciente();
    boolean that_present_nombrePaciente = true && that.isSetNombrePaciente();
    if (this_present_nombrePaciente || that_present_nombrePaciente) {
      if (!(this_present_nombrePaciente && that_present_nombrePaciente))
        return false;
      if (!this.nombrePaciente.equals(that.nombrePaciente))
        return false;
    }

    boolean this_present_fechaentrega = true && this.isSetFechaentrega();
    boolean that_present_fechaentrega = true && that.isSetFechaentrega();
    if (this_present_fechaentrega || that_present_fechaentrega) {
      if (!(this_present_fechaentrega && that_present_fechaentrega))
        return false;
      if (!this.fechaentrega.equals(that.fechaentrega))
        return false;
    }

    boolean this_present_tipo = true && this.isSetTipo();
    boolean that_present_tipo = true && that.isSetTipo();
    if (this_present_tipo || that_present_tipo) {
      if (!(this_present_tipo && that_present_tipo))
        return false;
      if (!this.tipo.equals(that.tipo))
        return false;
    }

    boolean this_present_descripcion = true && this.isSetDescripcion();
    boolean that_present_descripcion = true && that.isSetDescripcion();
    if (this_present_descripcion || that_present_descripcion) {
      if (!(this_present_descripcion && that_present_descripcion))
        return false;
      if (!this.descripcion.equals(that.descripcion))
        return false;
    }

    boolean this_present_fotoPaciente = true && this.isSetFotoPaciente();
    boolean that_present_fotoPaciente = true && that.isSetFotoPaciente();
    if (this_present_fotoPaciente || that_present_fotoPaciente) {
      if (!(this_present_fotoPaciente && that_present_fotoPaciente))
        return false;
      if (!this.fotoPaciente.equals(that.fotoPaciente))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReporteAnalisisPaciente other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetClavePaciente()).compareTo(other.isSetClavePaciente());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClavePaciente()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clavePaciente, other.clavePaciente);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetClaveAnalisis()).compareTo(other.isSetClaveAnalisis());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClaveAnalisis()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.claveAnalisis, other.claveAnalisis);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFechaAplic()).compareTo(other.isSetFechaAplic());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFechaAplic()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fechaAplic, other.fechaAplic);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNombrePaciente()).compareTo(other.isSetNombrePaciente());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNombrePaciente()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nombrePaciente, other.nombrePaciente);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFechaentrega()).compareTo(other.isSetFechaentrega());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFechaentrega()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fechaentrega, other.fechaentrega);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTipo()).compareTo(other.isSetTipo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTipo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tipo, other.tipo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescripcion()).compareTo(other.isSetDescripcion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescripcion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.descripcion, other.descripcion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFotoPaciente()).compareTo(other.isSetFotoPaciente());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFotoPaciente()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fotoPaciente, other.fotoPaciente);
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
    StringBuilder sb = new StringBuilder("ReporteAnalisisPaciente(");
    boolean first = true;

    sb.append("clavePaciente:");
    if (this.clavePaciente == null) {
      sb.append("null");
    } else {
      sb.append(this.clavePaciente);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("claveAnalisis:");
    if (this.claveAnalisis == null) {
      sb.append("null");
    } else {
      sb.append(this.claveAnalisis);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fechaAplic:");
    if (this.fechaAplic == null) {
      sb.append("null");
    } else {
      sb.append(this.fechaAplic);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nombrePaciente:");
    if (this.nombrePaciente == null) {
      sb.append("null");
    } else {
      sb.append(this.nombrePaciente);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fechaentrega:");
    if (this.fechaentrega == null) {
      sb.append("null");
    } else {
      sb.append(this.fechaentrega);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tipo:");
    if (this.tipo == null) {
      sb.append("null");
    } else {
      sb.append(this.tipo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("descripcion:");
    if (this.descripcion == null) {
      sb.append("null");
    } else {
      sb.append(this.descripcion);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fotoPaciente:");
    if (this.fotoPaciente == null) {
      sb.append("null");
    } else {
      sb.append(this.fotoPaciente);
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

  private static class ReporteAnalisisPacienteStandardSchemeFactory implements SchemeFactory {
    public ReporteAnalisisPacienteStandardScheme getScheme() {
      return new ReporteAnalisisPacienteStandardScheme();
    }
  }

  private static class ReporteAnalisisPacienteStandardScheme extends StandardScheme<ReporteAnalisisPaciente> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReporteAnalisisPaciente struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLAVE_PACIENTE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.clavePaciente = iprot.readString();
              struct.setClavePacienteIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CLAVE_ANALISIS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.claveAnalisis = iprot.readString();
              struct.setClaveAnalisisIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FECHA_APLIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fechaAplic = iprot.readString();
              struct.setFechaAplicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NOMBRE_PACIENTE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.nombrePaciente = iprot.readString();
              struct.setNombrePacienteIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // FECHAENTREGA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fechaentrega = iprot.readString();
              struct.setFechaentregaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TIPO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tipo = iprot.readString();
              struct.setTipoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // DESCRIPCION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.descripcion = iprot.readString();
              struct.setDescripcionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // FOTO_PACIENTE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fotoPaciente = iprot.readString();
              struct.setFotoPacienteIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReporteAnalisisPaciente struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.clavePaciente != null) {
        oprot.writeFieldBegin(CLAVE_PACIENTE_FIELD_DESC);
        oprot.writeString(struct.clavePaciente);
        oprot.writeFieldEnd();
      }
      if (struct.claveAnalisis != null) {
        oprot.writeFieldBegin(CLAVE_ANALISIS_FIELD_DESC);
        oprot.writeString(struct.claveAnalisis);
        oprot.writeFieldEnd();
      }
      if (struct.fechaAplic != null) {
        oprot.writeFieldBegin(FECHA_APLIC_FIELD_DESC);
        oprot.writeString(struct.fechaAplic);
        oprot.writeFieldEnd();
      }
      if (struct.nombrePaciente != null) {
        oprot.writeFieldBegin(NOMBRE_PACIENTE_FIELD_DESC);
        oprot.writeString(struct.nombrePaciente);
        oprot.writeFieldEnd();
      }
      if (struct.fechaentrega != null) {
        oprot.writeFieldBegin(FECHAENTREGA_FIELD_DESC);
        oprot.writeString(struct.fechaentrega);
        oprot.writeFieldEnd();
      }
      if (struct.tipo != null) {
        oprot.writeFieldBegin(TIPO_FIELD_DESC);
        oprot.writeString(struct.tipo);
        oprot.writeFieldEnd();
      }
      if (struct.descripcion != null) {
        oprot.writeFieldBegin(DESCRIPCION_FIELD_DESC);
        oprot.writeString(struct.descripcion);
        oprot.writeFieldEnd();
      }
      if (struct.fotoPaciente != null) {
        oprot.writeFieldBegin(FOTO_PACIENTE_FIELD_DESC);
        oprot.writeString(struct.fotoPaciente);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReporteAnalisisPacienteTupleSchemeFactory implements SchemeFactory {
    public ReporteAnalisisPacienteTupleScheme getScheme() {
      return new ReporteAnalisisPacienteTupleScheme();
    }
  }

  private static class ReporteAnalisisPacienteTupleScheme extends TupleScheme<ReporteAnalisisPaciente> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReporteAnalisisPaciente struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetClavePaciente()) {
        optionals.set(0);
      }
      if (struct.isSetClaveAnalisis()) {
        optionals.set(1);
      }
      if (struct.isSetFechaAplic()) {
        optionals.set(2);
      }
      if (struct.isSetNombrePaciente()) {
        optionals.set(3);
      }
      if (struct.isSetFechaentrega()) {
        optionals.set(4);
      }
      if (struct.isSetTipo()) {
        optionals.set(5);
      }
      if (struct.isSetDescripcion()) {
        optionals.set(6);
      }
      if (struct.isSetFotoPaciente()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetClavePaciente()) {
        oprot.writeString(struct.clavePaciente);
      }
      if (struct.isSetClaveAnalisis()) {
        oprot.writeString(struct.claveAnalisis);
      }
      if (struct.isSetFechaAplic()) {
        oprot.writeString(struct.fechaAplic);
      }
      if (struct.isSetNombrePaciente()) {
        oprot.writeString(struct.nombrePaciente);
      }
      if (struct.isSetFechaentrega()) {
        oprot.writeString(struct.fechaentrega);
      }
      if (struct.isSetTipo()) {
        oprot.writeString(struct.tipo);
      }
      if (struct.isSetDescripcion()) {
        oprot.writeString(struct.descripcion);
      }
      if (struct.isSetFotoPaciente()) {
        oprot.writeString(struct.fotoPaciente);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReporteAnalisisPaciente struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.clavePaciente = iprot.readString();
        struct.setClavePacienteIsSet(true);
      }
      if (incoming.get(1)) {
        struct.claveAnalisis = iprot.readString();
        struct.setClaveAnalisisIsSet(true);
      }
      if (incoming.get(2)) {
        struct.fechaAplic = iprot.readString();
        struct.setFechaAplicIsSet(true);
      }
      if (incoming.get(3)) {
        struct.nombrePaciente = iprot.readString();
        struct.setNombrePacienteIsSet(true);
      }
      if (incoming.get(4)) {
        struct.fechaentrega = iprot.readString();
        struct.setFechaentregaIsSet(true);
      }
      if (incoming.get(5)) {
        struct.tipo = iprot.readString();
        struct.setTipoIsSet(true);
      }
      if (incoming.get(6)) {
        struct.descripcion = iprot.readString();
        struct.setDescripcionIsSet(true);
      }
      if (incoming.get(7)) {
        struct.fotoPaciente = iprot.readString();
        struct.setFotoPacienteIsSet(true);
      }
    }
  }

}

