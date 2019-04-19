package ru.ftc.focusstart.unittests;

public class GetStatusUseCase {

    private static final String STATUS_DEFAULT = "STATUS_DEFAULT";

    private final StatusRepository statusRepository;

    public GetStatusUseCase(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public String invoke() {
        String status = statusRepository.getStatus();
        if (status == null) {
            status = STATUS_DEFAULT;
            statusRepository.setStatus(status);
        }
        return status;
    }
}
