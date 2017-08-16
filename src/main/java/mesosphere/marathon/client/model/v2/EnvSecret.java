package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

/**
 * @author Lewis Headden <lewis_headden@condenast.com>
 */
public class EnvSecret extends EnvValue {
	private String secret;

	public EnvSecret(final String secret) {
		this.secret = secret;

	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(final String secret) {
		this.secret = secret;
	}

	@Override
	public boolean isSecret() {
		return true;
	}

	@Override
	public EnvSecret getAsSecret() {
		return this;
	}

	@Override
	public boolean isString() {
		return false;
	}

	@Override
	public EnvString getAsString() {
		throw new IllegalStateException(this.getClass().getSimpleName() + " is not a " + EnvString.class.getSimpleName());
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final EnvSecret envSecret = (EnvSecret) o;

		return secret != null ? secret.equals(envSecret.secret) : envSecret.secret == null;
	}

	@Override
	public int hashCode() {
		return secret != null ? secret.hashCode() : 0;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
