package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

/**
 * @author Lewis Headden <lewis_headden@condenast.com>
 */
public class EnvString extends EnvValue {
	private String value;

	public EnvString(final String value) {
		this.value = value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean isSecret() {
		return false;
	}

	@Override
	public EnvSecret getAsSecret() {
		throw new IllegalStateException(this.getClass().getSimpleName() + " is not a " + EnvSecret.class.getSimpleName());
	}

	@Override
	public boolean isString() {
		return true;
	}

	@Override
	public EnvString getAsString() {
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final EnvString envString = (EnvString) o;

		return value != null ? value.equals(envString.value) : envString.value == null;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

}
