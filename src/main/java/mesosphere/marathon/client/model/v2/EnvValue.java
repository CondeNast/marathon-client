package mesosphere.marathon.client.model.v2;

import java.lang.reflect.Type;

import mesosphere.client.common.ModelUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Lewis Headden <lewis_headden@condenast.com>
 */
public class EnvValue {
	private String value;
	private boolean secret;

	public EnvValue(final String value, final boolean secret) {
		this.value = value;
		this.secret = secret;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(final boolean secret) {
		this.secret = secret;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final EnvValue envValue = (EnvValue) o;

		if (secret != envValue.secret) return false;
		return value != null ? value.equals(envValue.value) : envValue.value == null;
	}

	@Override
	public int hashCode() {
		int result = value != null ? value.hashCode() : 0;
		result = 31 * result + (secret ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

	public static class EnvValueAdapter implements JsonDeserializer<EnvValue>, JsonSerializer<EnvValue> {

		@Override
		public EnvValue deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			if (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has("secret"))
				return new EnvValue(jsonElement.getAsJsonObject().get("secret").getAsString(), true);
			else if (jsonElement.isJsonPrimitive()) {
				return new EnvValue(jsonElement.getAsString(), false);
			} else {
				throw new IllegalStateException("Cannot deserialize " + jsonElement.toString() + " as EnvValue");
			}
		}

		@Override
		public JsonElement serialize(EnvValue envValue, Type type, JsonSerializationContext jsonSerializationContext) {
			if (envValue.isSecret()) {
				final JsonObject secret = new JsonObject();
				secret.addProperty("secret", envValue.getValue());
				return secret;
			} else
				return new JsonPrimitive(envValue.getValue());
		}
	}
}

