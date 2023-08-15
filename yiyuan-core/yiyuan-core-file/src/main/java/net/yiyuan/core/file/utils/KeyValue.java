package net.yiyuan.core.file.utils;

import java.util.Objects;

/**
 * 键值对象
 *
 * @author CPYF-Yi Mao
 * @date 2019-02-03
 */
public final class KeyValue<K, V> {

  /** 键 */
  private K key;

  /** 值 */
  private V value;

  public KeyValue() {}

  public KeyValue(K key, V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * 新增
   *
   * @param key key
   * @param value value
   */
  public static <K, V> KeyValue<K, V> of(K key, V value) {
    return new KeyValue<>(key, value);
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValue<?, ?> keyValue = (KeyValue<?, ?>) o;
    return Objects.equals(key, keyValue.key) && Objects.equals(value, keyValue.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    return "KeyValue{" + "key=" + key + ", value=" + value + '}';
  }
}
