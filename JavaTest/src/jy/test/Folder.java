/**
 * @author chenjin
 * @version v1.0
 * @Organization {package_name} Folder.java
 * @createtime 2009-02-12
 * @modifytime
 */
package jy.test;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;
/**
 * 文件夹
 * {@link#Folder()}
 */
public class Folder  implements Serializable{
    private static final long serialVersionUID = 1L;
    protected int folderID = -1;
    protected String    folderName  = null ;
    protected String    folderType = null ;
    protected String    folderTypeName = null ;
    protected String    summary = null;
    protected Folder    parentFolder  = null;
    protected Set childFolders = null;
    protected Blob    templet = null ;
    protected String templetName=null;
    protected String folderConfig = null;
    protected String procName = null ;
    protected Set documents = null;
    protected String reservedChar1  = null;
    protected String reservedChar2  = null;
    protected String reservedChar3  = null;
    protected int reservedInt = 0;
    protected int folderSize=0;
    protected int oneFileSize=0;
    protected int addDocFormat=0;
    protected String addDocAddr=null;
    protected String attTypes=null;
    protected String author = null ;//创始人
    protected Date   createTime = null;//创建时间
    protected String lastModUser =null ;//最后一位文档修改人
    protected Date   lastModTime =null ;//最后修改时间
    protected Set docTypes = null;
    protected Set formFields = null;
    protected Set listFields = null;
    protected String titleDefaultValue=null;/*2010-03-19 新增标题默认值*/
    public Folder(){}
    public Folder(int folderID)
    {
        this.folderID=folderID;
    }
    /**
     * 文件夹编号
     * @return
     */
    public int getFolderID()
    {
        return this.folderID;
    }
    public void setFolderID(int folderID)
    {
        this.folderID=folderID;
    }
    /**
     * 文件夹名称
     * @return
     */
    public String getFolderName()
    {
        return this.folderName;
    }
    public void setFolderName(String folderName)
    {
        this.folderName=folderName;
    }

    /**
     * 文件夹类型
     * @return
     */
    public String getFolderType()
    {
        return this.folderType;
    }
    public void setFolderType(String folderType)
    {
        this.folderType=folderType;
    }

    /**
     * 文件夹类型名称
     * @return
     */
    public String getFolderTypeName()
    {
        /*****
         * 从数据字典中获取
         */
        return this.folderTypeName;
    }

    /**
     * 文件夹描述
     * @return
     */
    public String getSummary()
    {
        return this.summary;
    }
    public void setSummary(String summary)
    {
        this.summary=summary;
    }
    /**
     * 子文件夹
     * @return
     */
    public Set getChildFolders()
    {
        return this.childFolders;
    }
    public void setChildFolders(Set childFolders)
    {
        this.childFolders=childFolders;
    }

    /**
     * 添加一个子文件夹
     * @param folder
     */
    public void addChild(Folder folder)
    {
        folder.setParentFolder(this);
        childFolders.add(folder);
    }
    /**
     * 父文件夹
     * @return
     */
    public Folder getParentFolder()
    {
        return this.parentFolder;
    }
    public void setParentFolder(Folder parentFolder)
    {
        this.parentFolder=parentFolder;
    }

    /**
     * 文件夹下的文件模板
     * @return
     */
    public Blob getTemplet()
    {
        return this.templet;
    }
    public void setTemplet(Blob templet)
    {
        this.templet=templet;
    }

    /**
     * 模板文件名称
     * @return
     */
    public String getTempletName()
    {
        return this.templetName;
    }
    public void setTempletName(String templetName)
    {
        this.templetName=templetName;
    }

    /**
     * 文件夹配置
     * @return
     */
    public String getFolderConfig()
    {
        return this.folderConfig;
    }
    public void setFolderConfig(String folderConfig)
    {
        this.folderConfig=folderConfig;
    }

    /**
     * 文件夹对应流程名称
     * @return
     */
    public String getProcName()
    {
        return this.procName;
    }
    public void setProcName(String procName)
    {
        this.procName=procName;
    }

    /**
     * 获取文件件对应的文档
     * @return
     */
    public Set getDocuments()
    {
        return this.documents;
    }
    public void setDocuments(Set documents)
    {
        //
        this.documents=documents;
    }

    /**
     * 获取文档库对应子分类
     * @return
     */
    public Set getDocTypes()
    {
        return this.docTypes;
    }
    public void setDocTypes(Set docTypes)
    {
        //
        this.docTypes=docTypes;
    }
    /***
     * 预留字段
     */
    public String getReservedChar1()
    {
        return reservedChar1;
    }
    public void setReservedChar1(String reservedChar1)
    {
        this.reservedChar1=reservedChar1;
    }
    public String getReservedChar2()
    {
        return reservedChar2;
    }
    public void setReservedChar2(String reservedChar2)
    {
        this.reservedChar2=reservedChar2;
    }
    public String getReservedChar3()
    {
        return reservedChar3;
    }
    public void setReservedChar3(String reservedChar3)
    {
        this.reservedChar3=reservedChar3;
    }
    public int getReservedInt()
    {
        return reservedInt;
    }
    public void setReservedInt(int reservedInt)
    {
        this.reservedInt=reservedInt;
    }
    public int getFolderSize() {
        return folderSize;
    }
    public void setFolderSize(int folderSize) {
        this.folderSize = folderSize;
    }
    public int getOneFileSize() {
        return oneFileSize;
    }
    public void setOneFileSize(int oneFileSize) {
        this.oneFileSize = oneFileSize;
    }
    public String getAttTypes() {
        return attTypes;
    }
    public void setAttTypes(String attTypes) {
        this.attTypes = attTypes;
    }
    public void setFolderTypeName(String folderTypeName) {
        this.folderTypeName = folderTypeName;
    }
    public Set getFormFields() {
        return formFields;
    }
    public void setFormFields(Set formFields) {
        this.formFields = formFields;
    }

    public Set getListFields() {
        return listFields;
    }
    public void setListFields(Set listFields) {
        this.listFields = listFields;
    }
    public int getAddDocFormat() {
        return addDocFormat;
    }
    public void setAddDocFormat(int addDocFormat) {
        this.addDocFormat = addDocFormat;
    }
    public String getAddDocAddr() {
        return addDocAddr;
    }
    public void setAddDocAddr(String addDocAddr) {
        this.addDocAddr = addDocAddr;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getLastModUser() {
        return lastModUser;
    }
    public void setLastModUser(String lastModUser) {
        this.lastModUser = lastModUser;
    }
    public Date getLastModTime() {
        return lastModTime;
    }
    public void setLastModTime(Date lastModTime) {
        this.lastModTime = lastModTime;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public String getTitleDefaultValue() {
        return titleDefaultValue;
    }
    public void setTitleDefaultValue(String titleDefaultValue) {
        this.titleDefaultValue = titleDefaultValue;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderID=" + folderID +
                ", folderName='" + folderName + '\'' +
                ", folderType='" + folderType + '\'' +
                ", folderTypeName='" + folderTypeName + '\'' +
                ", summary='" + summary + '\'' +
                ", parentFolder=" + parentFolder +
                ", childFolders=" + childFolders +
                ", templet=" + templet +
                ", templetName='" + templetName + '\'' +
                ", folderConfig='" + folderConfig + '\'' +
                ", procName='" + procName + '\'' +
                ", documents=" + documents +
                ", reservedChar1='" + reservedChar1 + '\'' +
                ", reservedChar2='" + reservedChar2 + '\'' +
                ", reservedChar3='" + reservedChar3 + '\'' +
                ", reservedInt=" + reservedInt +
                ", folderSize=" + folderSize +
                ", oneFileSize=" + oneFileSize +
                ", addDocFormat=" + addDocFormat +
                ", addDocAddr='" + addDocAddr + '\'' +
                ", attTypes='" + attTypes + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", lastModUser='" + lastModUser + '\'' +
                ", lastModTime=" + lastModTime +
                ", docTypes=" + docTypes +
                ", formFields=" + formFields +
                ", listFields=" + listFields +
                ", titleDefaultValue='" + titleDefaultValue + '\'' +
                '}';
    }
}
