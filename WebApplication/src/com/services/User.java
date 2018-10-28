/**
 * User.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public class User  implements java.io.Serializable {
    private boolean driver;

    private java.lang.String email;

    private boolean finding;

    private int id;

    private java.lang.String imagePath;

    private java.lang.String name;

    private java.lang.String phoneNumber;

    private com.services.Location[] preferredLocations;

    private float star;

    private java.lang.String username;

    private int vote;

    public User() {
    }

    public User(
           boolean driver,
           java.lang.String email,
           boolean finding,
           int id,
           java.lang.String imagePath,
           java.lang.String name,
           java.lang.String phoneNumber,
           com.services.Location[] preferredLocations,
           float star,
           java.lang.String username,
           int vote) {
           this.driver = driver;
           this.email = email;
           this.finding = finding;
           this.id = id;
           this.imagePath = imagePath;
           this.name = name;
           this.phoneNumber = phoneNumber;
           this.preferredLocations = preferredLocations;
           this.star = star;
           this.username = username;
           this.vote = vote;
    }


    /**
     * Gets the driver value for this User.
     * 
     * @return driver
     */
    public boolean isDriver() {
        return driver;
    }


    /**
     * Sets the driver value for this User.
     * 
     * @param driver
     */
    public void setDriver(boolean driver) {
        this.driver = driver;
    }


    /**
     * Gets the email value for this User.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this User.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the finding value for this User.
     * 
     * @return finding
     */
    public boolean isFinding() {
        return finding;
    }


    /**
     * Sets the finding value for this User.
     * 
     * @param finding
     */
    public void setFinding(boolean finding) {
        this.finding = finding;
    }


    /**
     * Gets the id value for this User.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this User.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the imagePath value for this User.
     * 
     * @return imagePath
     */
    public java.lang.String getImagePath() {
        return imagePath;
    }


    /**
     * Sets the imagePath value for this User.
     * 
     * @param imagePath
     */
    public void setImagePath(java.lang.String imagePath) {
        this.imagePath = imagePath;
    }


    /**
     * Gets the name value for this User.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this User.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the phoneNumber value for this User.
     * 
     * @return phoneNumber
     */
    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Sets the phoneNumber value for this User.
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Gets the preferredLocations value for this User.
     * 
     * @return preferredLocations
     */
    public com.services.Location[] getPreferredLocations() {
        return preferredLocations;
    }


    /**
     * Sets the preferredLocations value for this User.
     * 
     * @param preferredLocations
     */
    public void setPreferredLocations(com.services.Location[] preferredLocations) {
        this.preferredLocations = preferredLocations;
    }

    public com.services.Location getPreferredLocations(int i) {
        return this.preferredLocations[i];
    }

    public void setPreferredLocations(int i, com.services.Location _value) {
        this.preferredLocations[i] = _value;
    }


    /**
     * Gets the star value for this User.
     * 
     * @return star
     */
    public float getStar() {
        return star;
    }


    /**
     * Sets the star value for this User.
     * 
     * @param star
     */
    public void setStar(float star) {
        this.star = star;
    }


    /**
     * Gets the username value for this User.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this User.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }


    /**
     * Gets the vote value for this User.
     * 
     * @return vote
     */
    public int getVote() {
        return vote;
    }


    /**
     * Sets the vote value for this User.
     * 
     * @param vote
     */
    public void setVote(int vote) {
        this.vote = vote;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.driver == other.isDriver() &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.finding == other.isFinding() &&
            this.id == other.getId() &&
            ((this.imagePath==null && other.getImagePath()==null) || 
             (this.imagePath!=null &&
              this.imagePath.equals(other.getImagePath()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.phoneNumber==null && other.getPhoneNumber()==null) || 
             (this.phoneNumber!=null &&
              this.phoneNumber.equals(other.getPhoneNumber()))) &&
            ((this.preferredLocations==null && other.getPreferredLocations()==null) || 
             (this.preferredLocations!=null &&
              java.util.Arrays.equals(this.preferredLocations, other.getPreferredLocations()))) &&
            this.star == other.getStar() &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            this.vote == other.getVote();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isDriver() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += (isFinding() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getId();
        if (getImagePath() != null) {
            _hashCode += getImagePath().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPhoneNumber() != null) {
            _hashCode += getPhoneNumber().hashCode();
        }
        if (getPreferredLocations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPreferredLocations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPreferredLocations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Float(getStar()).hashCode();
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        _hashCode += getVote();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(User.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.com/", "user"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("driver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "driver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finding");
        elemField.setXmlName(new javax.xml.namespace.QName("", "finding"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferredLocations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferredLocations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.com/", "location"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("star");
        elemField.setXmlName(new javax.xml.namespace.QName("", "star"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
