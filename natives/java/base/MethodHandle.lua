local MethodHandle = {};

local libjvm = require"java.libjvm";


function MethodHandle.Java_java_lang_invoke_MethodHandle_registerNatives(env,cl)
  local MethodHandleClass = libjvm.GetClassDefinition(libjvm.DereferenceObject(cl));
  local VirtualHandleClass = libjvm.FindClassDefinition("java/lang/invoke/MethodHandle$Virtual")
  local ZeroHandleClass = libjvm.FindClassDefintion("java/lang/invoke$Zero");
  local VM = libjvm.GetVM();
  local ProgramExecutor = VM:GetExecutor();
  local DynamicCallsites = VM:GetDynamicCallsitesInfo();
  local VirtualDispatcher = VM:GetVirtualDispatcher();
  local InvokeVirtual = libjvm.GetCallsiteInvokeVirtual();
  local InvokeDynamic = libjvm.GetCallsiteInvokeDynamic();
  local InvokeSpecial = libjvm.GetCallsiteInvokeSpecial();
  
  env:MonitorEnter(cl);
  
  (function()--Attach invokeExact
    local Binding = MethodHandleClass:GetMethodReference("invokeExact","([Ljava/lang/Object;)Ljava/lang/Object;");
    
    local InvokeExactCallsiteTarget = function(lookup,signature)
      return DynamicCallsites:BindTo(libjvm.GetCallsiteInvokeVirtual(),MethodHandleClass,"invokeExact",signature);
    end
    DynamicCallsites:attachBootstrapMethod(MethodHandleClass,"invokeExact",InvokeExactCallsiteTarget);
    
  end)();
  
  env:MonitorExit(cl);
  return;
end

return MethodHandle;