import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_ads_core_plugin/flutter_ads_core_plugin_method_channel.dart';

void main() {
  MethodChannelFlutterAdsCorePlugin platform = MethodChannelFlutterAdsCorePlugin();
  const MethodChannel channel = MethodChannel('flutter_ads_core_plugin');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  
}
