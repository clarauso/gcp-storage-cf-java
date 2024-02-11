package io.github.clarauso.storage.fnframework;

import java.time.OffsetDateTime;
import java.util.Map;

public class StorageObjectData {
  private String bucket;
  private String cacheControl;
  private Long componentCount;
  private String contentDisposition;
  private String contentEncoding;
  private String contentLanguage;
  private String contentType;
  private String crc32C;
  private String etag;
  private Boolean eventBasedHold;
  private String id;
  private String kind;
  private String kmsKeyName;
  private String md5Hash;
  private String mediaLink;
  private Map<String, String> metadata;
  private String name;
  private String selfLink;
  private String storageClass;
  private Boolean temporaryHold;

  public StorageObjectData() {}

  public String getBucket() {
    return this.bucket;
  }

  public void setBucket(String value) {
    this.bucket = value;
  }

  public String getCacheControl() {
    return this.cacheControl;
  }

  public void setCacheControl(String value) {
    this.cacheControl = value;
  }

  public Long getComponentCount() {
    return this.componentCount;
  }

  public void setComponentCount(Long value) {
    this.componentCount = value;
  }

  public String getContentDisposition() {
    return this.contentDisposition;
  }

  public void setContentDisposition(String value) {
    this.contentDisposition = value;
  }

  public String getContentEncoding() {
    return this.contentEncoding;
  }

  public void setContentEncoding(String value) {
    this.contentEncoding = value;
  }

  public String getContentLanguage() {
    return this.contentLanguage;
  }

  public void setContentLanguage(String value) {
    this.contentLanguage = value;
  }

  public String getContentType() {
    return this.contentType;
  }

  public void setContentType(String value) {
    this.contentType = value;
  }

  public String getCrc32C() {
    return this.crc32C;
  }

  public void setCrc32C(String value) {
    this.crc32C = value;
  }

  public String getEtag() {
    return this.etag;
  }

  public void setEtag(String value) {
    this.etag = value;
  }

  public Boolean getEventBasedHold() {
    return this.eventBasedHold;
  }

  public void setEventBasedHold(Boolean value) {
    this.eventBasedHold = value;
  }

  public String getID() {
    return this.id;
  }

  public void setID(String value) {
    this.id = value;
  }

  public String getKind() {
    return this.kind;
  }

  public void setKind(String value) {
    this.kind = value;
  }

  public String getKmsKeyName() {
    return this.kmsKeyName;
  }

  public void setKmsKeyName(String value) {
    this.kmsKeyName = value;
  }

  public String getMd5Hash() {
    return this.md5Hash;
  }

  public void setMd5Hash(String value) {
    this.md5Hash = value;
  }

  public String getMediaLink() {
    return this.mediaLink;
  }

  public void setMediaLink(String value) {
    this.mediaLink = value;
  }

  public Map<String, String> getMetadata() {
    return this.metadata;
  }

  public void setMetadata(Map<String, String> value) {
    this.metadata = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getSelfLink() {
    return this.selfLink;
  }

  public void setSelfLink(String value) {
    this.selfLink = value;
  }

  public String getStorageClass() {
    return this.storageClass;
  }

  public void setStorageClass(String value) {
    this.storageClass = value;
  }

  public Boolean getTemporaryHold() {
    return this.temporaryHold;
  }

  public void setTemporaryHold(Boolean value) {
    this.temporaryHold = value;
  }
}
