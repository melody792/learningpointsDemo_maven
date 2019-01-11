package com.pzb.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.logging.Logger;

public class RxJava {
    public static final Logger logger = Logger.getLogger(RxJava.class.getName());
    public static void main(String[] args) {
        rxJavaThread();
        //firstRxJava();

        //threadChange();
        //firstRxJavaLambda();
    }

    private static void rxJavaThread() {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                logger.info("Thread: "+Thread.currentThread().getName()+"-----emit: "+ 1);
                observableEmitter.onNext(1);
            }
        });

        Consumer consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer o) throws Exception {
                logger.info("Thread: "+Thread.currentThread().getName()+"-----accept: "+ o);
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(consumer);
    }

    private static void firstRxJavaLambda() {
        Observable.create(e -> {
            logger.info("Observable emit 111111");
            e.onNext(1);
            logger.info("Observable emit 1");
            e.onNext(2);
            logger.info("Observable emit 2");
            e.onNext(3);
            logger.info("Observable emit 3");
            e.onNext(4);
            logger.info("Observable emit 4");
        }).subscribe(i -> {
            logger.info(i+"");
            if(2 == Integer.parseInt(i.toString())){
                logger.info("hello");
            }
        });
    }

    private static void threadChange() {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {

            public void accept(@NonNull Integer integer) throws Exception {
                System.out.println("After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
            }
        }).observeOn(Schedulers.io()).subscribe(new Consumer<Integer>() {

            public void accept(@NonNull Integer integer) throws Exception {
                System.out.println("After observeOn(io)，Current thread is " + Thread.currentThread().getName());
            }
        });

    }

    private static void firstRxJava() {
        Observable.create(new ObservableOnSubscribe<Integer>() {//第一步 初始化Observable

            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                logger.info("Observable emit 1");
                e.onNext(1);
                //e.onComplete();
                logger.info("Observable emit 2");
                e.onNext(2);
                logger.info("Observable emit 3");
                e.onNext(3);
                //e.onComplete();
                logger.info("Observable emit 4");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {//第三步 订阅
            //第二步 初始化Observer
            private int i;
            private Disposable mDisposable;

            public void onSubscribe(Disposable disposable) {
                mDisposable = disposable;
                logger.info("onSubscribe");
            }

            public void onNext(Integer integer) {
                logger.info("onNext:" + integer);
                i++;
                if (i == 2) {
                    logger.info("dispose: " + mDisposable.isDisposed());
                    mDisposable.dispose();
                    logger.info("dispose: " + mDisposable.isDisposed());
                }
            }

            public void onError(Throwable e) {
                logger.info("onError" + e.getMessage());
            }

            public void onComplete() {
                logger.info("onComplete");
            }
        });
    }
}
