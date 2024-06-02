@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package io.foldright.cffu.kotlin

import io.foldright.cffu.Cffu
import io.foldright.cffu.CffuState
import io.foldright.cffu.CompletableFutureUtils
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.function.Function


////////////////////////////////////////////////////////////////////////////////
//# Extension methods for CompletableFuture
//  input and output(return type) is CompletableFuture
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////
//# allOf*/mostResultsOfSuccess* methods for Array/Collection
//
//    - allOfCompletableFuture
//    - allOfFastFailCompletableFuture
//    - allResultsOfCompletableFuture
//    - allResultsOfFastFailCompletableFuture
////////////////////////////////////////

/**
 * Returns a new CompletableFuture that is completed when all the given stages complete.
 * If any of the given stages complete exceptionally, then the returned CompletableFuture also does so,
 * with a CompletionException holding this exception as its cause.
 * Otherwise, the results, if any, of the given stages are not reflected
 * in the returned CompletableFuture, but may be obtained by inspecting them individually.
 * If no stages are provided, returns a CompletableFuture completed with the value `null`.
 *
 * If you need the results of given stages, prefer below methods:
 *
 *  - [allResultsOfCompletableFuture]
 *
 * This method is the same as [CompletableFutureUtils.allOf], providing this method is convenient for method chaining.
 *
 * @see allResultsOfCompletableFuture
 */
fun Collection<CompletionStage<*>>.allOfCompletableFuture(): CompletableFuture<Void> =
    CompletableFutureUtils.allOf(*toTypedArray())

/**
 * Returns a new CompletableFuture that is completed when all the given stages complete.
 * If any of the given stages complete exceptionally, then the returned CompletableFuture also does so,
 * with a CompletionException holding this exception as its cause.
 * Otherwise, the results, if any, of the given stages are not reflected
 * in the returned CompletableFuture, but may be obtained by inspecting them individually.
 * If no stages are provided, returns a CompletableFuture completed with the value `null`.
 *
 * If you need the results of given stages, prefer below methods:
 *
 *  - [allResultsOfCompletableFuture]
 *
 * This method is the same as [CompletableFutureUtils.allOf], providing this method is convenient for method chaining.
 *
 * @see allResultsOfCompletableFuture
 */
fun Array<out CompletionStage<*>>.allOfCompletableFuture(): CompletableFuture<Void> =
    CompletableFutureUtils.allOf(*this)

/**
 * Returns a new CompletableFuture that is successful when all the given CompletableFutures success,
 * the results(`CompletableFuture<Void>`) of the given CompletableFutures are not reflected in the returned CompletableFuture,
 * but may be obtained by inspecting them individually.
 * If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletableFutures,
 * with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns a CompletableFuture completed with the value `null`.
 *
 * If you need the results of given stages, prefer below methods:
 *
 *  - [allResultsOfFastFailCompletableFuture]
 *
 * This method is the same as [CompletableFutureUtils.allOfFastFail],
 * providing this method is convenient for method chaining.
 *
 * @see allResultsOfFastFailCompletableFuture
 */
fun Collection<CompletionStage<*>>.allOfFastFailCompletableFuture(): CompletableFuture<Void> =
    CompletableFutureUtils.allOfFastFail(*toTypedArray())

/**
 * Returns a new CompletableFuture that is successful when all the given CompletableFutures success,
 * the results(`CompletableFuture<Void>`) of the given CompletableFutures are not reflected in the returned CompletableFuture,
 * but may be obtained by inspecting them individually.
 * If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletableFutures,
 * with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns a CompletableFuture completed with the value `null`.
 *
 * If you need the results of given stages, prefer below methods:
 *
 *  - [allResultsOfFastFailCompletableFuture]
 *
 * This method is the same as [CompletableFutureUtils.allOfFastFail],
 * providing this method is convenient for method chaining.
 *
 * @see allResultsOfFastFailCompletableFuture
 */
fun Array<out CompletionStage<*>>.allOfFastFailCompletableFuture(): CompletableFuture<Void> =
    CompletableFutureUtils.allOfFastFail(*this)

/**
 * Returns a new CompletableFuture with the results in the **same order** of all the given
 * CompletableFutures, the returned new CompletableFuture is completed when all the given CompletableFutures complete.
 * If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture
 * also does so, with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns a CompletableFuture completed with the value empty list.
 *
 * This method is the same as [allOfCompletableFuture],
 * except the returned CompletableFuture contains the results of input CompletableFutures.
 *
 * This method is the same as [CompletableFutureUtils.allResultsOf],
 * providing this method is convenient for method chaining.
 *
 * @see allOfCompletableFuture
 */
fun <T> Collection<CompletionStage<out T>>.allResultsOfCompletableFuture(): CompletableFuture<List<T>> =
    CompletableFutureUtils.allResultsOf(*toTypedArray())

/**
 * Returns a new CompletableFuture with the results in the **same order** of all the given
 * CompletableFutures, the returned new CompletableFuture is completed when all the given CompletableFutures complete.
 * If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture
 * also does so, with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns a CompletableFuture completed with the value empty list.
 *
 * This method is the same as [allOfCompletableFuture],
 * except the returned CompletableFuture contains the results of input CompletableFutures.
 *
 * This method is the same as [CompletableFutureUtils.allResultsOf],
 * providing this method is convenient for method chaining.
 *
 * @see allOfCompletableFuture
 */
fun <T> Array<out CompletionStage<out T>>.allResultsOfCompletableFuture(): CompletableFuture<List<T>> =
    CompletableFutureUtils.allResultsOf(*this)

/**
 * Returns a new CompletableFuture with the results in the **same order** of all the given
 * CompletableFutures, the new CompletableFuture success when all the given CompletableFutures success.
 * If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletableFutures,
 * with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns a CompletableFuture completed with the value empty list.
 *
 * This method is the same as [allOfFastFailCompletableFuture],
 * except the returned CompletableFuture contains the results of input CompletableFutures.
 *
 * This method is the same as [CompletableFutureUtils.allResultsOfFastFail],
 * providing this method is convenient for method chaining.
 *
 * @see allOfFastFailCompletableFuture
 */
fun <T> Collection<CompletionStage<out T>>.allResultsOfFastFailCompletableFuture(): CompletableFuture<List<T>> =
    CompletableFutureUtils.allResultsOfFastFail(*toTypedArray())

/**
 * Returns a new CompletableFuture with the results in the **same order** of all the given
 * CompletableFutures, the new CompletableFuture success when all the given CompletableFutures success.
 * If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletableFutures,
 * with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns a CompletableFuture completed with the value empty list.
 *
 * This method is the same as [allOfFastFailCompletableFuture],
 * except the returned CompletableFuture contains the results of input CompletableFutures.
 *
 * This method is the same as [CompletableFutureUtils.allResultsOfFastFail],
 * providing this method is convenient for method chaining.
 *
 * @see allOfFastFailCompletableFuture
 */
fun <T> Array<out CompletionStage<out T>>.allResultsOfFastFailCompletableFuture(): CompletableFuture<List<T>> =
    CompletableFutureUtils.allResultsOfFastFail(*this)

/**
 * Returns a new CompletableFuture with the most results in the **same order** of
 * the given stages in the given time(`timeout`), aka as many results as possible in the given time.
 *
 * If the given stage is successful, its result is the completed value; Otherwise the given valueIfNotSuccess.
 *
 * @param timeout       how long to wait in units of `unit`
 * @param unit          a `TimeUnit` determining how to interpret the `timeout` parameter
 * @param valueIfNotSuccess the value to return if not completed successfully
 * @see getSuccessNow
 */
fun <T> Collection<CompletionStage<out T>>.mostResultsOfSuccessCompletableFuture(
    timeout: Long, unit: TimeUnit, valueIfNotSuccess: T
): CompletableFuture<List<T>> =
    CompletableFutureUtils.mostResultsOfSuccess(timeout, unit, valueIfNotSuccess, *toTypedArray())

/**
 * Returns a new CompletableFuture with the most results in the **same order** of
 * the given stages in the given time(`timeout`), aka as many results as possible in the given time.
 *
 * If the given stage is successful, its result is the completed value; Otherwise the given valueIfNotSuccess.
 *
 * @param timeout       how long to wait in units of `unit`
 * @param unit          a `TimeUnit` determining how to interpret the `timeout` parameter
 * @param valueIfNotSuccess the value to return if not completed successfully
 * @see getSuccessNow
 */
fun <T> Array<out CompletionStage<out T>>.mostResultsOfSuccessCompletableFuture(
    timeout: Long, unit: TimeUnit, valueIfNotSuccess: T
): CompletableFuture<List<T>> =
    CompletableFutureUtils.mostResultsOfSuccess(timeout, unit, valueIfNotSuccess, *this)

/**
 * Returns a new CompletableFuture with the most results in the **same order** of
 * the given stages in the given time(`timeout`), aka as many results as possible in the given time.
 *
 * If the given stage is successful, its result is the completed value; Otherwise the given valueIfNotSuccess.
 *
 * @param executorWhenTimeout the async executor when triggered by timeout
 * @param timeout       how long to wait in units of `unit`
 * @param unit          a `TimeUnit` determining how to interpret the `timeout` parameter
 * @param valueIfNotSuccess the value to return if not completed successfully
 * @see getSuccessNow
 */
fun <T> Collection<CompletionStage<out T>>.mostResultsOfSuccessCompletableFuture(
    executorWhenTimeout: Executor, timeout: Long, unit: TimeUnit, valueIfNotSuccess: T
): CompletableFuture<List<T>> =
    CompletableFutureUtils.mostResultsOfSuccess(
        executorWhenTimeout, timeout, unit, valueIfNotSuccess, *toTypedArray()
    )

/**
 * Returns a new CompletableFuture with the most results in the **same order** of
 * the given stages in the given time(`timeout`), aka as many results as possible in the given time.
 *
 * If the given stage is successful, its result is the completed value; Otherwise the given valueIfNotSuccess.
 *
 * @param executorWhenTimeout the async executor when triggered by timeout
 * @param timeout       how long to wait in units of `unit`
 * @param unit          a `TimeUnit` determining how to interpret the `timeout` parameter
 * @param valueIfNotSuccess the value to return if not completed successfully
 * @see getSuccessNow
 */
fun <T> Array<out CompletionStage<out T>>.mostResultsOfSuccessCompletableFuture(
    executorWhenTimeout: Executor, timeout: Long, unit: TimeUnit, valueIfNotSuccess: T
): CompletableFuture<List<T>> =
    CompletableFutureUtils.mostResultsOfSuccess(executorWhenTimeout, timeout, unit, valueIfNotSuccess, *this)

////////////////////////////////////////
//# anyOf* methods for Array/Collection
//
//    - anyOfCompletableFuture
//    - anyOfSuccessCompletableFuture
////////////////////////////////////////

/**
 * Returns a new CompletableFuture that is completed
 * when any of the given CompletableFutures complete, with the same result.
 * Otherwise, if it completed exceptionally, the returned CompletableFuture also does so,
 * with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns an incomplete CompletableFuture.
 *
 * This method is the same as [CompletableFutureUtils.anyOf], providing this method is convenient for method chaining.
 *
 * @see anyOfSuccessCompletableFuture
 */
fun <T> Collection<CompletionStage<out T>>.anyOfCompletableFuture(): CompletableFuture<T> =
    CompletableFutureUtils.anyOf(*toTypedArray())

/**
 * Returns a new CompletableFuture that is completed
 * when any of the given CompletableFutures complete, with the same result.
 * Otherwise, if it completed exceptionally, the returned CompletableFuture also does so,
 * with a CompletionException holding this exception as its cause.
 * If no CompletableFutures are provided, returns an incomplete CompletableFuture.
 *
 * This method is the same as [CompletableFutureUtils.anyOf], providing this method is convenient for method chaining.
 *
 * @see anyOfSuccessCompletableFuture
 */
fun <T> Array<out CompletionStage<out T>>.anyOfCompletableFuture(): CompletableFuture<T> =
    CompletableFutureUtils.anyOf(*this)

/**
 * Returns a new CompletableFuture that is successful when any of the given CompletableFutures success,
 * with the same result. Otherwise, all the given CompletableFutures complete exceptionally,
 * the returned CompletableFuture also does so, with a CompletionException holding
 * an exception from any of the given CompletableFutures as its cause. If no CompletableFutures are provided,
 * returns a new CompletableFuture that is already completed exceptionally with a CompletionException
 * holding a [NoCfsProvidedException][io.foldright.cffu.NoCfsProvidedException] as its cause.
 *
 * This method is the same as [CompletableFutureUtils.anyOfSuccess],
 * providing this method is convenient for method chaining.
 *
 * @see anyOfCompletableFuture
 */
fun <T> Collection<CompletionStage<out T>>.anyOfSuccessCompletableFuture(): CompletableFuture<T> =
    CompletableFutureUtils.anyOfSuccess(*toTypedArray())

/**
 * Returns a new CompletableFuture that is successful when any of the given CompletableFutures success,
 * with the same result. Otherwise, all the given CompletableFutures complete exceptionally,
 * the returned CompletableFuture also does so, with a CompletionException holding
 * an exception from any of the given CompletableFutures as its cause. If no CompletableFutures are provided,
 * returns a new CompletableFuture that is already completed exceptionally with a CompletionException
 * holding a [NoCfsProvidedException][io.foldright.cffu.NoCfsProvidedException] as its cause.
 *
 * This method is the same as [CompletableFutureUtils.anyOfSuccess],
 * providing this method is convenient for method chaining.
 *
 * @see anyOfCompletableFuture
 */
fun <T> Array<out CompletionStage<out T>>.anyOfSuccessCompletableFuture(): CompletableFuture<T> =
    CompletableFutureUtils.anyOfSuccess(*this)

////////////////////////////////////////////////////////////////////////////////
//# `then both(binary input)` methods with fast-fail support:
//
//    - runAfterBothFastFail*(Runnable):     Void, Void -> Void
//    - thenAcceptBothFastFail*(BiConsumer): (T1, T2) -> Void
//    - thenCombineFastFail*(BiFunction):    (T1, T2) -> U
////////////////////////////////////////////////////////////////////////////////

/**
 * Returns a new CompletableFuture that, when two given stages both complete normally, executes the given action.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture also does so
 * **without** waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.runAfterBoth] except for the fast-fail behavior.
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.runAfterBoth
 */
fun CompletionStage<*>.runAfterBothFastFail(other: CompletionStage<*>, action: Runnable): CompletableFuture<Void> =
    CompletableFutureUtils.runAfterBothFastFail(this, other, action)

/**
 * Returns a new CompletableFuture that, when two given stages both complete normally,
 * executes the given action using CompletableFuture's default asynchronous execution facility.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture also does so
 * **without** waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.runAfterBothAsync] except for the fast-fail behavior.
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.runAfterBothAsync
 */
fun CompletionStage<*>.runAfterBothFastFailAsync(other: CompletionStage<*>, action: Runnable): CompletableFuture<Void> =
    CompletableFutureUtils.runAfterBothFastFailAsync(this, other, action)

/**
 * Returns a new CompletableFuture that, when two given stages both complete normally,
 * executes the given action using the supplied executor.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so **without** waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.runAfterBothAsync] except for the fast-fail behavior.
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.runAfterBothAsync
 */
fun CompletionStage<*>.runAfterBothFastFailAsync(
    other: CompletionStage<*>, action: Runnable, executor: Executor
): CompletableFuture<Void> =
    CompletableFutureUtils.runAfterBothFastFailAsync(this, other, action, executor)

/**
 * Returns a new CompletableFuture that, when tow given stage both complete normally,
 * is executed with the two results as arguments to the supplied action.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.thenAcceptBoth] except for the fast-fail behavior.
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.thenAcceptBoth
 */
fun <T, U> CompletionStage<out T>.thenAcceptBothFastFail(
    other: CompletionStage<out U>, action: BiConsumer<in T, in U>
): CompletableFuture<Void> =
    CompletableFutureUtils.thenAcceptBothFastFail(this, other, action)

/**
 * Returns a new CompletableFuture that, when tow given stage both complete normally,
 * is executed using CompletableFuture's default asynchronous execution facility,
 * with the two results as arguments to the supplied action.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.thenAcceptBothAsync] except for the fast-fail behavior.
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.thenAcceptBothAsync
 */
fun <T, U> CompletionStage<out T>.thenAcceptBothFastFailAsync(
    other: CompletionStage<out U>, action: BiConsumer<in T, in U>
): CompletableFuture<Void> =
    CompletableFutureUtils.thenAcceptBothFastFailAsync(this, other, action)

/**
 * Returns a new CompletableFuture that, when tow given stage both complete normally,
 * is executed using the supplied executor,
 * with the two results as arguments to the supplied action.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.thenAcceptBothAsync] except for the fast-fail behavior.
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.thenAcceptBothAsync
 */
fun <T, U> CompletionStage<out T>.thenAcceptBothFastFailAsync(
    other: CompletionStage<out U>, action: BiConsumer<in T, in U>, executor: Executor
): CompletableFuture<Void> =
    CompletableFutureUtils.thenAcceptBothFastFailAsync(this, other, action, executor)

/**
 * Returns a new CompletableFuture that, when tow given stage both complete normally,
 * is executed with the two results as arguments to the supplied function.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.thenCombine] except for the fast-fail behavior.
 *
 * @param fn the function to use to compute the value of the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.thenCombine
 */
fun <T, U, V> CompletionStage<out T>.thenCombineFastFail(
    other: CompletionStage<out U>, fn: BiFunction<in T, in U, out V>
): CompletableFuture<V> =
    CompletableFutureUtils.thenCombineFastFail(this, other, fn)

/**
 * Returns a new CompletableFuture that, when tow given stage both complete normally,
 * is executed using CompletableFuture's default asynchronous execution facility,
 * with the two results as arguments to the supplied function.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.thenCombineAsync] except for the fast-fail behavior.
 *
 * @param fn the function to use to compute the value of the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.thenCombineAsync
 */
fun <T, U, V> CompletionStage<out T>.thenCombineFastFailAsync(
    other: CompletionStage<out U>, fn: BiFunction<in T, in U, out V>
): CompletableFuture<V> =
    CompletableFutureUtils.thenCombineFastFailAsync(this, other, fn)

/**
 * Returns a new CompletableFuture that, when tow given stage both complete normally,
 * is executed using the supplied executor,
 * with the two results as arguments to the supplied function.
 * if any of the given stage complete exceptionally, then the returned CompletableFuture
 * also does so *without* waiting other incomplete given CompletionStage,
 * with a CompletionException holding this exception as its cause.
 *
 * This method is the same as [CompletableFuture.thenCombineAsync] except for the fast-fail behavior.
 *
 * @param fn the function to use to compute the value of the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.thenCombineAsync
 */
fun <T, U, V> CompletionStage<out T>.thenCombineFastFailAsync(
    other: CompletionStage<out U>, fn: BiFunction<in T, in U, out V>, executor: Executor
): CompletableFuture<V> =
    CompletableFutureUtils.thenCombineFastFailAsync(this, other, fn, executor)

////////////////////////////////////////////////////////////////////////////////
//# `then either(binary input)` methods with either(any)-success support:
//
//    - runAfterEitherSuccess*(Runnable):  Void, Void -> Void
//    - acceptEitherSuccess*(Consumer):  (T, T) -> Void
//    - applyToEitherSuccess*(Function): (T, T) -> U
////////////////////////////////////////////////////////////////////////////////

/**
 * Returns a new CompletableFuture that, when either given stage success, executes the given action.
 * Otherwise, all two given CompletionStage complete exceptionally,
 * the returned CompletableFuture also does so, with a CompletionException holding
 * an exception from any of the given CompletionStage as its cause.
 *
 * This method is the same as [CompletableFuture.runAfterEither]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.runAfterEither
 */
fun CompletionStage<*>.runAfterEitherSuccess(other: CompletionStage<*>, action: Runnable): CompletableFuture<Void> =
    CompletableFutureUtils.runAfterEitherSuccess(this, other, action)

/**
 * Returns a new CompletableFuture that, when either given stage success, executes the given action
 * using CompletableFuture's default asynchronous execution facility.
 * Otherwise, all two given CompletionStage complete exceptionally,
 * the returned CompletableFuture also does so, with a CompletionException holding
 * an exception from any of the given CompletionStage as its cause.
 *
 * This method is the same as [CompletableFuture.runAfterEitherAsync]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.runAfterEitherAsync
 */
fun CompletionStage<*>.runAfterEitherSuccessAsync(
    other: CompletionStage<*>, action: Runnable
): CompletableFuture<Void> =
    CompletableFutureUtils.runAfterEitherSuccessAsync(this, other, action)

/**
 * Returns a new CompletableFuture that, when either given stage success, executes the given action
 * using the supplied executor.
 * Otherwise, all two given CompletionStage complete exceptionally,
 * the returned CompletableFuture also does so, with a CompletionException holding
 * an exception from any of the given CompletionStage as its cause.
 *
 * This method is the same as [CompletableFuture.runAfterEitherAsync]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.runAfterEitherAsync
 */
fun CompletionStage<*>.runAfterEitherSuccessAsync(
    other: CompletionStage<*>, action: Runnable, executor: Executor
): CompletableFuture<Void> =
    CompletableFutureUtils.runAfterEitherSuccessAsync(this, other, action, executor)

/**
 * Returns a new CompletableFuture that, when either given stage success,
 * is executed with the corresponding result as argument to the supplied action.
 *
 * This method is the same as [CompletableFuture.acceptEither]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.acceptEither
 */
fun <T> CompletionStage<out T>.acceptEitherSuccess(
    other: CompletionStage<out T>, action: Consumer<in T>
): CompletableFuture<Void> =
    CompletableFutureUtils.acceptEitherSuccess(this, other, action)

/**
 * Returns a new CompletionStage that, when either given stage success,
 * is executed using this stage's default asynchronous execution facility,
 * with the corresponding result as argument to the supplied action.
 *
 * This method is the same as [CompletableFuture.acceptEitherAsync]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param action the action to perform before completing the returned CompletableFuture
 * @return the new CompletableFuture
 * @see CompletionStage.acceptEitherAsync
 */
fun <T> CompletionStage<out T>.acceptEitherSuccessAsync(
    other: CompletionStage<out T>, action: Consumer<in T>
): CompletableFuture<Void> =
    CompletableFutureUtils.acceptEitherSuccessAsync(this, other, action)

/**
 * Returns a new CompletionStage that, when either given stage success,
 * is executed using the supplied executor, with the corresponding result as argument to the supplied action.
 *
 * This method is the same as [CompletableFuture.acceptEitherAsync]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param action   the action to perform before completing the returned CompletableFuture
 * @param executor the executor to use for asynchronous execution
 * @return the new CompletableFuture
 * @see CompletionStage.acceptEitherAsync
 */
fun <T> CompletionStage<out T>.acceptEitherSuccessAsync(
    other: CompletionStage<out T>, action: Consumer<in T>, executor: Executor
): CompletableFuture<Void> =
    CompletableFutureUtils.acceptEitherSuccessAsync(this, other, action, executor)

/**
 * Returns a new CompletionStage that, when either given stage success,
 * is executed with the corresponding result as argument to the supplied function.
 *
 * This method is the same as [CompletableFuture.applyToEither]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param fn  the function to use to compute the value of the returned CompletableFuture
 * @param <U> the function's return type
 * @return the new CompletableFuture
 * @see CompletionStage.applyToEither
 */
fun <T, U> CompletionStage<out T>.applyToEitherSuccess(
    other: CompletionStage<out T>, fn: Function<in T, out U>
): CompletableFuture<U> =
    CompletableFutureUtils.applyToEitherSuccess(this, other, fn)

/**
 * Returns a new CompletionStage that, when either given stage success,
 * is executed using this stage's default asynchronous execution facility,
 * with the corresponding result as argument to the supplied function.
 *
 * This method is the same as [CompletableFuture.applyToEitherAsync]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param fn  the function to use to compute the value of the returned CompletableFuture
 * @param <U> the function's return type
 * @return the new CompletableFuture
 * @see CompletionStage.applyToEitherAsync
 */
fun <T, U> CompletionStage<out T>.applyToEitherSuccessAsync(
    other: CompletionStage<out T>, fn: Function<in T, out U>
): CompletableFuture<U> =
    CompletableFutureUtils.applyToEitherSuccessAsync(this, other, fn)

/**
 * Returns a new CompletionStage that, when either given stage success,
 * is executed using the supplied executor, with the corresponding result as argument to the supplied function.
 *
 * This method is the same as [CompletableFuture.applyToEitherAsync]
 * except for the either-**success** behavior(not either-**complete**).
 *
 * @param fn       the function to use to compute the value of the returned CompletableFuture
 * @param executor the executor to use for asynchronous execution
 * @param <U>      the function's return type
 * @return the new CompletableFuture
 * @see CompletionStage.applyToEitherAsync
 */
fun <T, U> CompletionStage<out T>.applyToEitherSuccessAsync(
    other: CompletionStage<out T>, fn: Function<in T, out U>, executor: Executor
): CompletableFuture<U> =
    CompletableFutureUtils.applyToEitherSuccessAsync(this, other, fn, executor)

////////////////////////////////////////////////////////////////////////////////
//# New enhanced methods
////////////////////////////////////////////////////////////////////////////////

/**
 * Peeks the result by executing the given action when this stage completes, returns this stage.
 *
 * When this stage is complete, the given action is invoked with the result (or `null` if none)
 * and the exception (or `null` if none) of given stage as arguments. Whether the supplied action
 * throws an exception or not, this stage is **NOT** affected.
 *
 * Unlike method [handle][CompletionStage.handle] and like method [whenComplete][CompletionStage.whenComplete],
 * this method is not designed to translate completion outcomes.
 *
 * @param action the action to perform
 * @return this stage
 * @see CompletionStage.whenComplete
 * @see java.util.stream.Stream.peek
 */
fun <T, C : CompletionStage<out T>> C.peek(action: BiConsumer<in T, in Throwable>): C =
    CompletableFutureUtils.peek(this, action)

/**
 * Peeks the result by executing the given action when this stage completes,
 * executes the given action using this stage's default asynchronous execution facility, returns this stage.
 *
 * When this stage is complete, the given action is invoked with the result (or `null` if none)
 * and the exception (or `null` if none) of given stage as arguments. Whether the supplied action
 * throws an exception or not, this stage is **NOT** affected.
 *
 * Unlike method [handle][CompletionStage.handle] and like method [whenComplete][CompletionStage.whenComplete],
 * this method is not designed to translate completion outcomes.
 *
 * @param action the action to perform
 * @return this stage
 * @see CompletionStage.whenCompleteAsync
 * @see java.util.stream.Stream.peek
 */
fun <T, C : CompletionStage<out T>> C.peekAsync(action: BiConsumer<in T, in Throwable>): C =
    CompletableFutureUtils.peekAsync(this, action)

/**
 * Peeks the result by executing the given action when this stage completes,
 * executes the given action using the supplied Executor, returns this stage.
 *
 * When this stage is complete, the given action is invoked with the result (or `null` if none)
 * and the exception (or `null` if none) of given stage as arguments. Whether the supplied action
 * throws an exception or not, this stage is **NOT** affected.
 *
 * Unlike method [handle][CompletionStage.handle] and like method [whenComplete][CompletionStage.whenComplete],
 * this method is not designed to translate completion outcomes.
 *
 * @param action the action to perform
 * @return this stage
 * @see CompletionStage.whenCompleteAsync
 * @see java.util.stream.Stream.peek
 */
fun <T, C : CompletionStage<out T>> C.peekAsync(action: BiConsumer<in T, in Throwable>, executor: Executor): C =
    CompletableFutureUtils.peekAsync(this, action, executor)

////////////////////////////////////////
// toCompletableFuture methods
////////////////////////////////////////

/**
 * Convert [CompletionStage] (including [Cffu]) collection elements to [CompletableFuture].
 *
 * This method is the same as [CompletableFutureUtils.toCompletableFutureArray],
 * providing this method is convenient for method chaining.
 */
fun <T> Collection<CompletionStage<T>>.toCompletableFuture(): List<CompletableFuture<T>> =
    map { it.toCompletableFuture() }

/**
 * Convert [CompletionStage] (including [Cffu]) array elements to [CompletableFuture].
 *
 * This method is the same as [CompletableFutureUtils.toCompletableFutureArray],
 * providing this method is convenient for method chaining.
 */
fun <T> Array<out CompletionStage<T>>.toCompletableFuture(): Array<CompletableFuture<T>> =
    CompletableFutureUtils.toCompletableFutureArray(*this)

////////////////////////////////////////////////////////////////////////////////
//# Backport CF instance methods
//  compatibility for low Java version
////////////////////////////////////////////////////////////////////////////////

//# Error Handling methods of CompletionStage

/**
 * Returns a new CompletionStage that, when given stage completes exceptionally, is executed with given
 * stage's exception as the argument to the supplied function, using given stage's
 * default asynchronous execution facility. Otherwise, if given stage completes normally,
 * then the returned stage also completes normally with the same value.
 *
 * @param fn the function to use to compute the value of the returned CompletionStage
 * if given CompletionStage completed exceptionally
 * @return the new CompletionStage
 */
fun <T, C : CompletionStage<in T>> C.exceptionallyAsync(fn: Function<Throwable, out T>): C =
    CompletableFutureUtils.exceptionallyAsync(this, fn)

/**
 * Returns a new CompletionStage that, when given stage completes exceptionally, is executed with given
 * stage's exception as the argument to the supplied function, using the supplied Executor. Otherwise,
 * if given stage completes normally, then the returned stage also completes normally with the same value.
 *
 * @param fn       the function to use to compute the value of the returned CompletionStage
 * if given CompletionStage completed exceptionally
 * @param executor the executor to use for asynchronous execution
 * @return the new CompletionStage
 */
fun <T, C : CompletionStage<in T>> C.exceptionallyAsync(fn: Function<Throwable, out T>, executor: Executor): C =
    CompletableFutureUtils.exceptionallyAsync(this, fn, executor)

//# Timeout Control methods

/**
 * Exceptionally completes this CompletableFuture with a TimeoutException
 * if not otherwise completed before the given timeout.
 *
 * Uses CompletableFuture's default asynchronous execution facility as `executorWhenTimeout`.
 *
 * **CAUTION:** If the wait timed out, the returned CompletableFuture complete exceptionally with a CompletionException
 * holding the [TimeoutException] as its cause; NOT a direct [TimeoutException] like [orTimeout]/[CompletableFuture.orTimeout].
 *
 * @param timeout how long to wait before completing exceptionally with a TimeoutException, in units of `unit`
 * @param unit    a `TimeUnit` determining how to interpret the `timeout` parameter
 * @return the new CompletableFuture
 */
fun <T, C : CompletableFuture<out T>> C.cffuOrTimeout(timeout: Long, unit: TimeUnit): C =
    CompletableFutureUtils.cffuOrTimeout(this, timeout, unit)

/**
 * Exceptionally completes this CompletableFuture with a TimeoutException
 * if not otherwise completed before the given timeout.
 *
 * **CAUTION:** If the wait timed out, the returned CompletableFuture complete exceptionally with a CompletionException
 * holding the [TimeoutException] as its cause; NOT a direct [TimeoutException] like [orTimeout]/[CompletableFuture.orTimeout].
 *
 * @param executorWhenTimeout the async executor when triggered by timeout
 * @param timeout how long to wait before completing exceptionally with a TimeoutException, in units of `unit`
 * @param unit    a `TimeUnit` determining how to interpret the `timeout` parameter
 * @return the new CompletableFuture
 */
fun <T, C : CompletableFuture<out T>> C.cffuOrTimeout(executorWhenTimeout: Executor, timeout: Long, unit: TimeUnit): C =
    CompletableFutureUtils.cffuOrTimeout(this, executorWhenTimeout, timeout, unit)

/**
 * Exceptionally completes this CompletableFuture with a [TimeoutException]
 * if not otherwise completed before the given timeout.
 *
 * **CAUTION:** This method and [CompletableFuture.orTimeout] is **UNSAFE**!
 *
 * When triggered by timeout, the subsequent non-async actions of the dependent CompletableFutures
 * are performed in the **SINGLE thread builtin executor**
 * of CompletableFuture for delay execution (including timeout function).
 * So the long-running subsequent non-async actions lead to the CompletableFuture dysfunction
 * (including delay execution and timeout).
 *
 * **Strong recommend** using the safe method [cffuOrTimeout]
 * instead of this method and [CompletableFuture.orTimeout].
 *
 * Unless all subsequent actions of dependent CompletableFutures is ensured executing async
 * (aka. the dependent CompletableFutures is created by async methods), using this method and [CompletableFuture.orTimeout]
 * is one less thread switch of task execution when triggered by timeout.
 *
 * @param timeout how long to wait before completing exceptionally with a TimeoutException, in units of `unit`
 * @param unit    a `TimeUnit` determining how to interpret the `timeout` parameter
 * @return this CompletableFuture
 * @see cffuOrTimeout
 */
fun <T, C : CompletableFuture<out T>> C.orTimeout(timeout: Long, unit: TimeUnit): C =
    CompletableFutureUtils.orTimeout(this, timeout, unit)

/**
 * Completes this CompletableFuture with the given value if not otherwise completed before the given timeout.
 *
 * Uses CompletableFuture's default asynchronous execution facility as `executorWhenTimeout`.
 *
 * @param value   the value to use upon timeout
 * @param timeout how long to wait before completing normally with the given value, in units of `unit`
 * @param unit    a `TimeUnit` determining how to interpret the `timeout` parameter
 * @return the new CompletableFuture
 */
fun <T, C : CompletableFuture<in T>> C.cffuCompleteOnTimeout(
    value: T, timeout: Long, unit: TimeUnit
): C =
    CompletableFutureUtils.cffuCompleteOnTimeout(this, value, timeout, unit)

/**
 * Completes this CompletableFuture with the given value if not otherwise completed before the given timeout.
 *
 * @param value   the value to use upon timeout
 * @param executorWhenTimeout the async executor when triggered by timeout
 * @param timeout how long to wait before completing normally with the given value, in units of `unit`
 * @param unit    a `TimeUnit` determining how to interpret the `timeout` parameter
 * @return the new CompletableFuture
 */
fun <T, C : CompletableFuture<in T>> C.cffuCompleteOnTimeout(
    value: T, executorWhenTimeout: Executor, timeout: Long, unit: TimeUnit
): C =
    CompletableFutureUtils.cffuCompleteOnTimeout(this, value, executorWhenTimeout, timeout, unit)

/**
 * Completes this CompletableFuture with the given value if not otherwise completed before the given timeout.
 *
 * **CAUTION:** This method and [CompletableFuture.completeOnTimeout] is **UNSAFE**!
 *
 * When triggered by timeout, the subsequent non-async actions of the dependent CompletableFutures
 * are performed in the **SINGLE thread builtin executor**
 * of CompletableFuture for delay execution (including timeout function).
 * So the long-running subsequent non-async actions lead to the CompletableFuture dysfunction
 * (including delay execution and timeout).
 *
 * **Strong recommend** using the safe method [cffuCompleteOnTimeout]
 * instead of this method and [CompletableFuture.completeOnTimeout].
 *
 * Unless all subsequent actions of dependent CompletableFutures is ensured executing async
 * (aka. the dependent CompletableFutures is created by async methods), using this method and [CompletableFuture.completeOnTimeout]
 * is one less thread switch of task execution when triggered by timeout.
 *
 * @param value   the value to use upon timeout
 * @param timeout how long to wait before completing normally with the given value, in units of `unit`
 * @param unit    a `TimeUnit` determining how to interpret the `timeout` parameter
 * @return this CompletableFuture
 * @see cffuCompleteOnTimeout
 */
fun <T, C : CompletableFuture<in T>> C.completeOnTimeout(value: T, timeout: Long, unit: TimeUnit): C =
    CompletableFutureUtils.completeOnTimeout(this, value, timeout, unit)

//# Advanced methods of CompletionStage

/**
 * Returns a new CompletionStage that, when given stage completes exceptionally,
 * is composed using the results of the supplied function applied to given stage's exception.
 *
 * @param fn the function to use to compute the returned
 *           CompletionStage if given CompletionStage completed exceptionally
 * @return the new CompletionStage
 */
fun <T, C : CompletionStage<in T>> C.exceptionallyCompose(fn: Function<Throwable, out CompletionStage<T>>): C =
    CompletableFutureUtils.exceptionallyCompose(this, fn)

/**
 * Returns a new CompletionStage that, when given stage completes exceptionally,
 * is composed using the results of the supplied function applied to given stage's exception,
 * using given stage's default asynchronous execution facility.
 *
 * @param fn the function to use to compute the returned
 *           CompletionStage if given CompletionStage completed exceptionally
 * @return the new CompletionStage
 */
fun <T, C : CompletionStage<in T>> C.exceptionallyComposeAsync(fn: Function<Throwable, out CompletionStage<T>>): C =
    CompletableFutureUtils.exceptionallyComposeAsync(this, fn)

/**
 * Returns a new CompletionStage that, when given stage completes exceptionally, is composed using
 * the results of the supplied function applied to given stage's exception, using the supplied Executor.
 *
 * @param fn       the function to use to compute the returned CompletionStage
 *                 if given CompletionStage completed exceptionally
 * @param executor the executor to use for asynchronous execution
 * @return the new CompletionStage
 */
fun <T, C : CompletionStage<in T>> C.exceptionallyComposeAsync(
    fn: Function<Throwable, out CompletionStage<T>>, executor: Executor
): C =
    CompletableFutureUtils.exceptionallyComposeAsync(this, fn, executor)

//# Read(explicitly) methods of CompletableFuture

/**
 * Waits if necessary for at most the given time for the computation to complete,
 * and then retrieves its result value when complete, or throws an (unchecked) exception if completed exceptionally.
 *
 * **NOTE:** Calling this method
 *
 * `val result = cf.join(timeout, unit);`
 *
 * is the same as:
 *
 * ```
 * val result = cf.copy() // defensive copy to avoid writing this cf unexpectedly
 *     .orTimeout(timeout, unit)
 *     .join();
 * ```
 *
 * **CAUTION:** If the wait timed out, this method throws an (unchecked) CompletionException
 * with the TimeoutException as its cause; NOT throws a (checked) TimeoutException like [CompletableFuture.get].
 *
 * @param timeout the maximum time to wait
 * @param unit    the time unit of the timeout argument
 * @return the result value
 * @see CompletableFuture.join
 */
@Suppress("UNCHECKED_CAST")
fun <T> CompletableFuture<T>.join(timeout: Long, unit: TimeUnit): T =
    CompletableFutureUtils.join(this, timeout, unit) as T

/**
 * Returns the result value if completed successfully, else returns the given valueIfNotSuccess.
 *
 * This method will not throw exceptions
 * (CancellationException/CompletionException/ExecutionException/IllegalStateException/...).
 *
 * @param valueIfNotSuccess the value to return if not completed successfully
 * @return the result value, if completed successfully, else the given valueIfNotSuccess
 */
@Suppress("UNCHECKED_CAST")
fun <T> CompletableFuture<T>.getSuccessNow(valueIfNotSuccess: T): T =
    CompletableFutureUtils.getSuccessNow(this, valueIfNotSuccess) as T

/**
 * Returns the computed result, without waiting.
 *
 * This method is for cases where the caller knows that the task has already completed successfully,
 * for example when filtering Future objects for the successful tasks
 * and using a mapping operation to obtain results.
 *
 * ```
 * val results = futures
 *     .filter { it.state() == Future.State.SUCCESS }
 *     .map { it.resultNow() }
 * ```
 */
@Suppress("UNCHECKED_CAST")
fun <T> Future<T>.resultNow(): T =
    CompletableFutureUtils.resultNow(this) as T

/**
 * Returns the exception thrown by the task, without waiting.
 *
 * This method is for cases where the caller knows that the task has already completed with an exception.
 *
 * @return the exception thrown by the task
 * @throws IllegalStateException if the task has not completed, the task completed normally,
 *                               or the task was cancelled
 */
fun Future<*>.exceptionNow(): Throwable =
    CompletableFutureUtils.exceptionNow(this)

/**
 * Returns the computation state([CffuState]), this method is equivalent to [CompletableFuture.state]
 * with java version compatibility logic, so you can invoke in old `java 18-`.
 *
 * @return the computation state
 * @see java.util.concurrent.Future.state
 * @see CompletableFuture.state
 */
fun Future<*>.cffuState(): CffuState =
    CompletableFutureUtils.state(this)

//# Write methods of CompletableFuture

/**
 * Completes given CompletableFuture with the result of the given Supplier function invoked
 * from an asynchronous task using the default executor.
 *
 * @param supplier a function returning the value to be used to complete given CompletableFuture
 * @return given CompletableFuture
 */
fun <T, C : CompletableFuture<in T>> C.completeAsync(supplier: Supplier<out T>): C =
    CompletableFutureUtils.completeAsync(this, supplier)

/**
 * Completes given CompletableFuture with the result of the given Supplier function invoked
 * from an asynchronous task using the given executor.
 *
 * @param supplier a function returning the value to be used to complete given CompletableFuture
 * @param executor the executor to use for asynchronous execution
 * @return given CompletableFuture
 */
fun <T, C : CompletableFuture<in T>> C.completeAsync(supplier: Supplier<out T>, executor: Executor): C =
    CompletableFutureUtils.completeAsync(this, supplier, executor)

/**
 * If not already completed, completes given CompletableFuture with the exception result
 * of the given Supplier function invoked from an asynchronous task using the default executor.
 *
 * @param supplier a function returning the value to be used to complete given CompletableFuture
 * @return the given CompletableFuture
 * @see CompletableFuture.completeExceptionally
 */
fun <C : CompletableFuture<*>> C.completeExceptionallyAsync(supplier: Supplier<out Throwable>): C =
    CompletableFutureUtils.completeExceptionallyAsync(this, supplier)

/**
 * If not already completed, completes given CompletableFuture with the exception result
 * of the given Supplier function invoked from an asynchronous task using the given executor.
 *
 * @param supplier a function returning the value to be used to complete given CompletableFuture
 * @param executor the executor to use for asynchronous execution
 * @return the given CompletableFuture
 * @see CompletableFuture.completeExceptionally
 */
fun <C : CompletableFuture<*>> C.completeExceptionallyAsync(supplier: Supplier<out Throwable>, executor: Executor): C =
    CompletableFutureUtils.completeExceptionallyAsync(this, supplier, executor)

//# Re-Config methods

/**
 * Returns a new CompletionStage that is completed normally with the same value as given CompletableFuture
 * when it completes normally, and cannot be independently completed or otherwise used in ways
 * not defined by the methods of interface [CompletionStage].
 * If given CompletableFuture completes exceptionally, then the returned CompletionStage completes exceptionally
 * with a CompletionException with given exception as cause.
 *
 * ***CAUTION:*** if run on old Java 8, just return a ***normal*** CompletableFuture
 * which is NOT with a ***minimal*** CompletionStage.
 *
 * @return the new CompletionStage
 */
fun <T> CompletableFuture<T>.minimalCompletionStage(): CompletionStage<T> =
    CompletableFutureUtils.minimalCompletionStage(this)

/**
 * Returns a new CompletableFuture that is completed normally with the same value as this CompletableFuture when
 * it completes normally. If this CompletableFuture completes exceptionally, then the returned CompletableFuture
 * completes exceptionally with a CompletionException with this exception as cause. The behavior is equivalent
 * to `thenApply(x -> x)`. This method may be useful as a form of "defensive copying", to prevent clients
 * from completing, while still being able to arrange dependent actions.
 *
 * @return the new CompletableFuture
 */
fun <T> CompletableFuture<T>.copy(): CompletableFuture<T> =
    CompletableFutureUtils.copy(this)

/**
 * Returns a new incomplete CompletableFuture of the type to be returned by a CompletionStage method.
 *
 * @param <T> the type of the value
 * @return a new CompletableFuture
 */
fun <U> CompletableFuture<*>.newIncompleteFuture(): CompletableFuture<U> =
    CompletableFutureUtils.newIncompleteFuture(this)
