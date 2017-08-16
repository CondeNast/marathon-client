package mesosphere.marathon.client.model.v2;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Lewis Headden <lewis_headden@condenast.com>
 */
public abstract class EnvValue {

	public abstract boolean isSecret();

	public abstract EnvSecret getAsSecret();

	public abstract boolean isString();

	public abstract EnvString getAsString();

	public static class EnvValueAdapter implements JsonDeserializer<EnvValue>, JsonSerializer<EnvValue> {

		@Override
		public EnvValue deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			if (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has("secret"))
				return jsonDeserializationContext.deserialize(jsonElement, EnvSecret.class);
			else if (jsonElement.isJsonPrimitive()) {
				return new EnvString(jsonElement.getAsString());
			} else {
				throw new IllegalStateException("Cannot deserialize " + jsonElement.toString() + " as EnvValue");
			}
		}

		@Override
		public JsonElement serialize(EnvValue envValue, Type type, JsonSerializationContext jsonSerializationContext) {
			if (envValue instanceof EnvString) {
				return new JsonPrimitive(((EnvString) envValue).getValue());
			} else if (envValue instanceof EnvSecret) {
				return jsonSerializationContext.serialize(envValue);
			} else {
				throw new IllegalStateException("Cannot serialize " + envValue.getClass());
			}
		}
	}

}
