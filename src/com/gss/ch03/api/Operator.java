package com.gss.ch03.api;

import java.util.List;

/**
 * This Operator class is the base class for all user defined operators.
 * @param <I> The data type of the events in the incoming stream
 * @param <O> The data type of the events in the outgoing stream
 */
public abstract class Operator<I, O> implements IOperator<I, O> {
  private String name;
  private int parallelism;
  protected Stream<O> outgoingStream = new Stream<O>();

  public Operator(String name, int parallelism) {
    this.name = name;
    this.parallelism = parallelism;
  }

  /**
   * Get the outgoing stream of the component.
   * @return The outgoing stream
   */
  public Stream<O> getOutgoingStream() { return outgoingStream; }

  /**
   * Get the name of this component.
   * @return The name of this component.
   */
  public String getName() { return name; }

  /**
   * Get the parallelism (number of instances) of this component.
   * @return The parallelism (number of instances) of this component.
   */
  public int getParallelism() { return parallelism; }

  /**
   * Apply logic to the incoming event and generate results.
   * The function is abstract and needs to be implemented by users.
   * @param event The incoming event
   * @param eventCollector The outgoing event collector
   */
  public abstract void apply(I event, List<O> eventCollector);
}
