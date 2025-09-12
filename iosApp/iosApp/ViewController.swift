//
//  ViewController.swift
//  iosApp
//
//  Created by Himanshu Mehra on 12/09/25.
//
import UIKit
import ComposeApp

class ViewController: UIViewController{
    private var monitor: SwiftInternetMonitor?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let mObserver = IOSConnectivityObserver()
        monitor = SwiftInternetMonitor(observer: mObserver)
        monitor?.startMonitoring()
    }
    
    deinit {
        monitor?.stopMonitoring()
    }
    
}

