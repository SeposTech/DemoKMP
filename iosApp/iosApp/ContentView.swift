import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    private var monitor: SwiftInternetMonitor?
    
    init() {
            // Attach observer
            let observer = IOSConnectivityObserver()
            monitor = SwiftInternetMonitor(observer: observer)
            monitor?.startMonitoring() // Now monitoring starts
        }
    
    var body: some View {
        ComposeView()
            .ignoresSafeArea()
            .onDisappear {
                monitor?.stopMonitoring()
            }
    }
}



