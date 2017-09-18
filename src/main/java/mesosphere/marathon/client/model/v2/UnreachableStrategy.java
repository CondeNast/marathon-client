package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class UnreachableStrategy {
    private Double inactiveAfterSeconds;
    private Double expungeAfterSeconds;

    public Double getInactiveAfterSeconds() {
        return inactiveAfterSeconds;
    }

    public void setInactiveAfterSeconds(Double inactiveAfterSeconds) {
        this.inactiveAfterSeconds = inactiveAfterSeconds;
    }

    public Double getExpungeAfterSeconds() {
        return expungeAfterSeconds;
    }

    public void setExpungeAfterSeconds(Double expungeAfterSeconds) {
        this.expungeAfterSeconds = expungeAfterSeconds;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
