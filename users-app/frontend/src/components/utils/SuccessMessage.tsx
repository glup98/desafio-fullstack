import { Check } from 'lucide-react';

interface SuccessMessageProps {
  message: string;
  submessage?: string;
}

export const SuccessMessage: React.FC<SuccessMessageProps> = ({ message, submessage }) => {
  return (
    <div className='flex flex-col items-center justify-center text-center'>
      <Check />
      <p className='text-lg font-bold my-1'>{message}</p>
      {submessage && <p className='text-base my-1'>{submessage}</p>}
    </div>
  );
};
