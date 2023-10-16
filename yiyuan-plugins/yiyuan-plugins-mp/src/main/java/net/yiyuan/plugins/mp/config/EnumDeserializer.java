package net.yiyuan.plugins.mp.config;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Data
@EqualsAndHashCode(callSuper = true)
public class EnumDeserializer extends JsonDeserializer<Enum<?>> implements ContextualDeserializer {

  private Class<?> target;

  @SuppressWarnings("all")
  @Override
  public Enum<?> deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
    if (!StringUtils.hasText(jsonParser.getText())) {
      return null;
    }
    if (IEnum.class.isAssignableFrom(target)) {
      return (Enum<?>)
          StringCodeToEnumConverterFactory.getEnum((Class) target, jsonParser.getText());
    }
    return null;
  }

  /**
   * @param ctx ctx
   * @param property property
   * @return 1
   * @throws JsonMappingException
   */
  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext ctx, BeanProperty property)
      throws JsonMappingException {
    Class<?> rawCls = ctx.getContextualType().getRawClass();
    EnumDeserializer enumDeserializer = new EnumDeserializer();
    enumDeserializer.setTarget(rawCls);
    return enumDeserializer;
  }
}
