package es.smurfdad.flogger;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.smurfdad.flogger.model.vo.OptionsVO;

public class FileAlterationObserver extends
		org.apache.commons.io.monitor.FileAlterationObserver {

	private static final long serialVersionUID = 1L;
	private static final Logger cLogger = LoggerFactory.getLogger(FileAlterationObserver.class);
	private static final Logger cSalida = LoggerFactory.getLogger("app");
	private OptionsVO cOptions;
			
	public FileAlterationObserver(File pDirectory, OptionsVO pOptions) {
		super(pDirectory, null);
		cOptions = pOptions;
		addListener(new FileAlterationListener() {

			public void onStart(
					org.apache.commons.io.monitor.FileAlterationObserver pObserver) {
					cLogger.debug("Inicio escaneo de {}",pObserver.getDirectory());
			}

			public void onDirectoryCreate(File pDirectory) {
				if(cOptions.getCarpeta().isAdd()){
					log(pDirectory,FileAction.ADD);
				}
			}

			public void onDirectoryChange(File pDirectory) {
				if(cOptions.getCarpeta().isChange()){
					log(pDirectory,FileAction.MODIFIED);
				}
			}

			public void onDirectoryDelete(File pDirectory) {
				if(cOptions.getCarpeta().isDelete()){
					log(pDirectory,FileAction.DELETE);
				}
			}

			public void onFileCreate(File pFile) {
				if(cOptions.getFichero().isAdd()){
					log(pFile,FileAction.ADD);
				}
			}

			public void onFileChange(File pFile) {
				if(cOptions.getFichero().isChange()){
					log(pFile,FileAction.MODIFIED);
				}
			}

			public void onFileDelete(File pFile) {
				if(cOptions.getFichero().isDelete()){
					log(pFile,FileAction.DELETE);
				}
			}

			public void onStop(
					org.apache.commons.io.monitor.FileAlterationObserver pObserver) {
				cLogger.debug("Fin escaneo de {}",pObserver.getDirectory());
			}
		});
		
		
	}
	
	@Override
	public void checkAndNotify() {
		super.checkAndNotify();
		cLogger.debug("checkAndNotify");
	}

	private void log(File pFichero, FileAction pAction ){
//		cLogger.info("{}\t-->\t {}", pAction, pFichero);
		cSalida.info("{} {}", pAction, pFichero);
	}
}
