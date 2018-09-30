package by.den.algorithms.core;

import java.util.Objects;

/**
 * A convenience base class for sort algorithms.
 * This class implements {@link #getName()} so that subclasses don't need to.
 */
public abstract class AbstractSortAlgorithm implements SortAlgorithm {

	private final String name;

	protected AbstractSortAlgorithm(String name) {
		Objects.requireNonNull(name);
		this.name = name;
	}

	public final String getName() {
		return name;
	}
	
}
