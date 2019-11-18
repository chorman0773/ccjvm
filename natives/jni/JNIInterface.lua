local JNIInterface = {};

local libjvm = require"java.libjvm"; 

function JNIInterface:GetVersion()
  return libjvm.VersionRelease();
end

function JNIInterface:DefineClass(name,loader,buf)
  if libjvm.CheckForAsynchronousException() then
    return nil;
  end
  local Loader = libjvm.dereferenceObject(loader);
  local cldef,except = libjvm.CreateClassDefinition(Loader,name,buf);
  if not cldef then
    libjvm.RaiseSynchronous(except);
    return nil;
  end
  local clobj = libjvm.GetClassObject(cldef);
  return libjvm.toJNIObject(clobj);
end

function JNIInterface:FindClass(name)
  if libjvm.CheckForAsynchronousException() then
    return nil;
  end
  local cldef, except = libjvm.FindClassDefinition(libjvm.ContextClassLoader(),name);
  if not cldef then
    libjvm.RaiseSynchronous(except);
  end
  local clobj = libjvm.GetClassObject(cldef);
  return libjvm.toJNIObject(clobj);
end

return JNIInterface;