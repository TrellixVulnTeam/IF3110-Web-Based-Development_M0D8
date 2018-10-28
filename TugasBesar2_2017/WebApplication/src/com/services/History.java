/**
 * History.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public class History  implements java.io.Serializable {
    private java.lang.String date;

    private java.lang.String destination;

    private java.lang.String feedback;

    private boolean hiddenCust;

    private boolean hiddenDriver;

    private int id;

    private int idCustomer;

    private int idDriver;

    private java.lang.String pickUp;

    private int rating;

    public History() {
    }

    public History(
           java.lang.String date,
           java.lang.String destination,
           java.lang.String feedback,
           boolean hiddenCust,
           boolean hiddenDriver,
           int id,
           int idCustomer,
           int idDriver,
           java.lang.String pickUp,
           int rating) {
           this.date = date;
           this.destination = destination;
           this.feedback = feedback;
           this.hiddenCust = hiddenCust;
           this.hiddenDriver = hiddenDriver;
           this.id = id;
           this.idCustomer = idCustomer;
           this.idDriver = idDriver;
           this.pickUp = pickUp;
           this.rating = rating;
    }


    /**
     * Gets the date value for this History.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this History.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the destination value for this History.
     * 
     * @return destination
     */
    public java.lang.String getDestination() {
        return destination;
    }


    /**
     * Sets the destination value for this History.
     * 
     * @param destination
     */
    public void setDestination(java.lang.String destination) {
        this.destination = destination;
    }


    /**
     * Gets the feedback value for this History.
     * 
     * @return feedback
     */
    public java.lang.String getFeedback() {
        return feedback;
    }


    /**
     * Sets the feedback value for this History.
     * 
     * @param feedback
     */
    public void setFeedback(java.lang.String feedback) {
        this.feedback = feedback;
    }


    /**
     * Gets the hiddenCust value for this History.
     * 
     * @return hiddenCust
     */
    public boolean isHiddenCust() {
        return hiddenCust;
    }


    /**
     * Sets the hiddenCust value for this History.
     * 
     * @param hiddenCust
     */
    public void setHiddenCust(boolean hiddenCust) {
        this.hiddenCust = hiddenCust;
    }


    /**
     * Gets the hiddenDriver value for this History.
     * 
     * @return hiddenDriver
     */
    public boolean isHiddenDriver() {
        return hiddenDriver;
    }


    /**
     * Sets the hiddenDriver value for this History.
     * 
     * @param hiddenDriver
     */
    public void setHiddenDriver(boolean hiddenDriver) {
        this.hiddenDriver = hiddenDriver;
    }


    /**
     * Gets the id value for this History.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this History.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the idCustomer value for this History.
     * 
     * @return idCustomer
     */
    public int getIdCustomer() {
        return idCustomer;
    }


    /**
     * Sets the idCustomer value for this History.
     * 
     * @param idCustomer
     */
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }


    /**
     * Gets the idDriver value for this History.
     * 
     * @return idDriver
     */
    public int getIdDriver() {
        return idDriver;
    }


    /**
     * Sets the idDriver value for this History.
     * 
     * @param idDriver
     */
    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }


    /**
     * Gets the pickUp value for this History.
     * 
     * @return pickUp
     */
    public java.lang.String getPickUp() {
        return pickUp;
    }


    /**
     * Sets the pickUp value for this History.
     * 
     * @param pickUp
     */
    public void setPickUp(java.lang.String pickUp) {
        this.pickUp = pickUp;
    }


    /**
     * Gets the rating value for this History.
     * 
     * @return rating
     */
    public int getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this History.
     * 
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof History)) return false;
        History other = (History) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.destination==null && other.getDestination()==null) || 
             (this.destination!=null &&
              this.destination.equals(other.getDestination()))) &&
            ((this.feedback==null && other.getFeedback()==null) || 
             (this.feedback!=null &&
              this.feedback.equals(other.getFeedback()))) &&
            this.hiddenCust == other.isHiddenCust() &&
            this.hiddenDriver == other.isHiddenDriver() &&
            this.id == other.getId() &&
            this.idCustomer == other.getIdCustomer() &&
            this.idDriver == other.getIdDriver() &&
            ((this.pickUp==null && other.getPickUp()==null) || 
             (this.pickUp!=null &&
              this.pickUp.equals(other.getPickUp()))) &&
            this.rating == other.getRating();
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
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getDestination() != null) {
            _hashCode += getDestination().hashCode();
        }
        if (getFeedback() != null) {
            _hashCode += getFeedback().hashCode();
        }
        _hashCode += (isHiddenCust() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHiddenDriver() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getId();
        _hashCode += getIdCustomer();
        _hashCode += getIdDriver();
        if (getPickUp() != null) {
            _hashCode += getPickUp().hashCode();
        }
        _hashCode += getRating();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(History.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.com/", "history"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destination");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feedback");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feedback"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hiddenCust");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hiddenCust"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hiddenDriver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hiddenDriver"));
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
        elemField.setFieldName("idCustomer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCustomer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDriver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDriver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pickUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pickUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rating");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rating"));
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
