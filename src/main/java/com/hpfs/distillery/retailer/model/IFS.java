/**
 *
 */
package com.hpfs.distillery.retailer.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hpfs.distillery.retailer.repository.IDGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ram
 *
 */
@Entity
@Table(name = "ifs_m")
public class IFS implements Serializable {

    @Id
    @GeneratedValue(generator = IDGenerator.generatorName)
    @GenericGenerator(name = IDGenerator.generatorName, strategy = "com.hpfs.distillery.retailer.repository.IFSIDGenerator")
    @Column(name = "ifs_num")
    private String ifsNo;

    @Column(name = "ifs_type")
    private String ifsType;

    @Column(name = "consignment_type")
    private String consignmentType;

    @Column(name = "distillery_id")
    private Long distilleryId;

    @Column(name = "depot_id")
    private Long depotId;

    @Column(name = "status")
    private String status;

    @Column(name = "indent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indentDate;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ifs_num", insertable = true, updatable = true, nullable=false)
    private List<IFSProducts> iFSProducts = new ArrayList<>();

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    public List<IFSProducts> getiFSProducts() {
        return iFSProducts;
    }

    public void setiFSProducts(List<IFSProducts> iFSProducts) {
        this.iFSProducts = iFSProducts;
    }

    public String getIfsNo() {
        return ifsNo;
    }

    public void setIfsNo(String ifsNo) {
        this.ifsNo = ifsNo;
    }

    public Long getDistilleryId() {
        return distilleryId;
    }

    public void setDistilleryId(Long distilleryId) {
        this.distilleryId = distilleryId;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getIfsType() {
        return ifsType;
    }

    public void setIfsType(String ifsType) {
        this.ifsType = ifsType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsignmentType() {
        return consignmentType;
    }

    public void setConsignmentType(String consignmentType) {
        this.consignmentType = consignmentType;
    }

    public Date getIndentDate() {
        return indentDate;
    }

    public void setIndentDate(Date indentDate) {
        this.indentDate = indentDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "IFS{" +
                "ifsNo='" + ifsNo + '\'' +
                ", ifsType='" + ifsType + '\'' +
                ", consignmentType='" + consignmentType + '\'' +
                ", distilleryId=" + distilleryId +
                ", depotId=" + depotId +
                ", status='" + status + '\'' +
                ", indentDate=" + indentDate +
                ", iFSProducts=" + iFSProducts +
                ", creationDate=" + creationDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IFS)) return false;
        IFS ifs = (IFS) o;
        return getIfsNo().equals(ifs.getIfsNo()) &&
                getIfsType().equals(ifs.getIfsType()) &&
                getConsignmentType().equals(ifs.getConsignmentType()) &&
                getDistilleryId().equals(ifs.getDistilleryId()) &&
                getDepotId().equals(ifs.getDepotId()) &&
                getStatus().equals(ifs.getStatus()) &&
                getIndentDate().equals(ifs.getIndentDate()) &&
                Objects.equals(getiFSProducts(), ifs.getiFSProducts()) &&
                getCreationDate().equals(ifs.getCreationDate()) &&
                getCreatedBy().equals(ifs.getCreatedBy()) &&
                getUpdatedDate().equals(ifs.getUpdatedDate()) &&
                getUpdatedBy().equals(ifs.getUpdatedBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIfsNo(), getIfsType(), getConsignmentType(), getDistilleryId(), getDepotId(), getStatus(), getIndentDate(), getiFSProducts(), getCreationDate(), getCreatedBy(), getUpdatedDate(), getUpdatedBy());
    }
}
