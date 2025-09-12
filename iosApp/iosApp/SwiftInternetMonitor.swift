//
//  SwiftInternetMonitor.swift
//  iosApp
//
//  Created by Himanshu Mehra on 12/09/25.
//
import ComposeApp
import Foundation
import Network

class SwiftInternetMonitor {
    private var monitor = NWPathMonitor()
    private var observer = IOSConnectivityObserver()
    
    init(observer: IOSConnectivityObserver) {
        self.observer = observer
    }
    
    func startMonitoring() {
            monitor.pathUpdateHandler = { path in
                if path.status == .satisfied {
                    
                    self.observer.setStatus(available: true)
                } else {
                   
                    self.observer.setStatus(available: false)
                }
            }
            
            let queue = DispatchQueue(label: "InternetMonitor")
            monitor.start(queue: queue)
        }
    
    func stopMonitoring() {
            monitor.cancel()
        }
}

