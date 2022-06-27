package com.experiment.rxjava;


//import io.reactivex.Observable;
//import io.reactivex.ObservableEmitter;
//import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.Observer;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Consumer;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author wuruohong
 * @date 2022-06-16 10:39
 */
public class RxJavaStudy {
    /*public static void main1(String[] args) {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        // 创建观察者
        Observer<Integer> observer = new Observer<Integer>() {
            // 观察者接收事件前，默认最先调用复写onsubscribe
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("对被观察的事件做出相应： value：" + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对被观察者的error事件做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对被观察者的complete事件做出响应");
            }
        };
        observable.subscribe(observer);
    }

    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                TimeUnit.MILLISECONDS.sleep(100);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onNext(6);
                TimeUnit.MILLISECONDS.sleep(100);
                emitter.onNext(7);
                emitter.onNext(8);
                emitter.onNext(9);
                TimeUnit.MILLISECONDS.sleep(100);
                emitter.onNext(10);
                emitter.onComplete();
            }
                }).throttleFirst(10, TimeUnit.MILLISECONDS)
                .subscribe(new Observer<Integer>() {
            // 观察者接收事件前，默认最先调用复写onsubscribe
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("对被观察的事件做出相应： value：" + integer + " time: " + System.currentTimeMillis());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对被观察者的error事件做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对被观察者的complete事件做出响应");
            }
        });
    }

    @Test
    public void Test88() {
        Observable.just("hello").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("接收数据：" + s);
            }
        });

    }*/
}
